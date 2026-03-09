package com.library.dao;

import com.library.db.DatabaseConnection;
import com.library.model.LibraryCard;
import com.library.model.User;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public User getUserWithCard(int userId){
        User user = null;
        String sql = """
                SELECT 
                u.user_id, u.first_name, u.last_name, u.email,
                lc.card_number , lc.card_id, lc.issue_date
                FROM users u
                JOIN library_cards lc
                ON u.card_id = lc.card_id
                WHERE u.user_id = ?
                """;
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setInt(1,userId);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){

                LibraryCard card = new LibraryCard();
                card.setCardNumber(rs.getString("card_number"));
                card.setCardId(rs.getInt("card_id"));
                card.setIssueDate(rs.getDate("issue_date").toLocalDate());

                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));

                user.setCard(card);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
      return user;
    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();
        User user = dao.getUserWithCard(2);
        System.out.println(user);
    }
}
