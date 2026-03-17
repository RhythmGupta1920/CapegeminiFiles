package com.library.dao;

import com.library.db.DatabaseConnection;
import com.library.model.Author;
import com.library.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookAuthorMappingDAO {
    public boolean linkBookToAuthor(int bookId, int authorId) {
        BookDAO bookDAO = new BookDAO();
        Book book = bookDAO.getBook(bookId);
        if (book == null) {
            return false;
        }

        AuthorDAO authorDAO = new AuthorDAO();
        Author author = authorDAO.getAuthor(authorId);
        if (author == null) {
            return false;
        }

        String sql = "INSERT INTO book_author_mapping (book_id, author_id) VALUES (?,?)";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ){
           pstmt.setInt(1,bookId);
           pstmt.setInt(2,authorId);

           int rowsAffected = pstmt.executeUpdate();

           if(rowsAffected >0){
               System.out.println("Successfully linked");
           }
           else {
               System.out.println("Failed to link");
           }
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
    public List<Book> getAllBooksWithAuthors(){
        Map<Integer, Book> bookMap = new HashMap<>();

        String sql = "SELECT " +
                "b.book_id, b.title, b.isbn, " +
                "a.author_id, a.first_name, a.last_name " +
                "FROM books b " +
                "JOIN book_author_mapping bam " +
                "ON b.book_id = bam.book_id " +
                "JOIN authors a " +
                "ON bam.author_id = a.author_id";

        try(Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ){
            while(rs.next()){
                 int bookId = rs.getInt("book_id");
                  Book book = bookMap.get(bookId);

                 if(book == null){
                     book = new Book();
                     book.setBookId(bookId);
                     book.setTitle(rs.getString("title"));
                     book.setIsbn(rs.getString("isbn"));
                     book.setAuthors(new ArrayList<>());

                     bookMap.put(bookId, book);
                 }
                Author author = new Author();
                author.setAuthorId(rs.getInt("author_id"));
                author.setFirstName(rs.getString("first_name"));
                author.setLastName(rs.getString("last_name"));

                book.getAuthors().add(author);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return new ArrayList<>(bookMap.values());
    }

    public static void main(String[] args) {
        BookAuthorMappingDAO dao = new BookAuthorMappingDAO();

        List<Book> books = dao.getAllBooksWithAuthors();
        books.forEach(System.out::println);

//        dao.linkBookToAuthor(17, 11);
//        dao.linkBookToAuthor(18, 12);
    }
}
