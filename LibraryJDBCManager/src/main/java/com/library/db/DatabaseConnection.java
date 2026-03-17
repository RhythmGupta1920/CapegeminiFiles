package com.library.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class DatabaseConnection {
    //connection class properties
     private static final String URL = "jdbc:mysql://localhost:3306/";
     private static final  String DATABASE_NAME = "library_jdbc_db";
     private static final String USERNAME = "root";
     private static final String PASSWORD = "Arhythm.jun1920";

     private static final String DB_URL = URL+ DATABASE_NAME;

     private DatabaseConnection() {

     }

     public static Connection getConnection() {
         Connection conn = null;

         try{
             conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
             System.out.print("Connection created successfully");
         }
         catch(SQLException e){
             System.out.println("Failed to create connection");
             e.printStackTrace();
         }
         return conn;

     }

    public static void main(String[] args) {
        getConnection();
    }

}
