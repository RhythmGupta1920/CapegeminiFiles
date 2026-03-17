package com.library.dao;

import com.library.db.DatabaseConnection;
import com.library.model.Author;
import com.library.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorDAO {
    public Author getAuthor(int authorId){
        Author author = null;

        String sql = "SELECT * FROM authors WHERE author_id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ){
            pstmt.setInt(1,authorId);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                   author = new Author(authorId, rs.getString("first_name"), rs.getString("last_name"));
                }
            }
        }
        catch(SQLException e ){
            e.printStackTrace();
        }
        return author;

    }
    public void saveAuthor(Author author){
        String sql = "INSERT into authors(first_name, last_name) VALUES (?,?)";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setString(1,author.getFirstName());
            pstmt.setString(2, author.getLastName());

            int rowsAffected = pstmt.executeUpdate();

            if(rowsAffected>0){
                System.out.println("Author added successfully");
            }
            else {
                System.out.println("Failed to add the author ");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AuthorDAO dao = new AuthorDAO();

        Author author1 = new Author(0, "Brian", "Goetz");
        dao.saveAuthor(author1);

        Author author2 = new Author(0, "Raoul-Gabriel", "Urma");
        dao.saveAuthor(author2);
    }
}
