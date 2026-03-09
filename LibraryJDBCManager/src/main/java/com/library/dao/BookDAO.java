package com.library.dao;

import com.library.db.DatabaseConnection;
import com.library.model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.mysql.cj.protocol.Resultset;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public Book getBook(int bookId){
        Book book = null;

        String sql = "SELECT * FROM books WHERE book_id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
          pstmt.setInt(1,bookId);
           try(ResultSet rs = pstmt.executeQuery()){
               if(rs.next()){
                  book = new Book(bookId,rs.getString("title"), rs.getString("isbn"));
               }
           }
        }
        catch(SQLException e ){
            e.printStackTrace();
        }
        return book;

    }
    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM books";

        try(Connection conn = DatabaseConnection.getConnection();
           Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setIsbn(rs.getString("isbn"));

                books.add(book);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
            return books;
    }
    public void addBooks(Book book){
        String sql = "INSERT INTO books (title, isbn) VALUES (?,?)";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getIsbn());

            int rowsAffected = pstmt.executeUpdate();

            if(rowsAffected >0){
                System.out.println("Book Added Successfully");
            }
            else {
                System.out.println("Failed to add Book into records");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updateBookTitle(int bookId, String newTitle){
        String sql = "UPDATE books SET title = ? WHERE book_id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, newTitle);
            pstmt.setInt(2, bookId);

            int rowsAffected = pstmt.executeUpdate();

            if(rowsAffected >0){
                System.out.println("Book Title Updated Successfully");
            }
            else {
                System.out.println("Failed to update Book title");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteBook(int bookId){
        String sql = "DELETE FROM books WHERE book_id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1, bookId);

            int rowsAffected = pstmt.executeUpdate();

            if(rowsAffected >0){
                System.out.println("Book Deleted Successfully" + bookId);
            }
            else {
                System.out.println("Failed to delete Book into records" + bookId);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BookDAO dao = new BookDAO();

//        Book newBook1 = new Book(0, "The Great Gatsby", "978-0743273565");
//        dao.addBooks(newBook1);
//
//
//        Book newBook2 = new Book(0, "1984", "978-0451524935");
//        dao.addBooks(newBook2);

//        System.out.println("updating book title");
//        dao.updateBookTitle(11, "Harry Potter");

        Book book1 = new Book(0, "Java Concurrency in Practice", "978-0321349606");
        dao.addBooks(book1);

        Book book2 = new Book(0, "Modern Java in Action", "978-1617293566");
        dao.addBooks(book2);

//        dao.deleteBook(11);
//        dao.deleteBook(12);

        List<Book> books = dao.getAllBooks();
        books.forEach(System.out::println);
    }
}

