package edu.icet.ecom.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;

    private DBConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/layos","root","1234");
    }

    public static  DBConnection getInstance() throws SQLException {
        if(instance == null){
            instance = new DBConnection();
        }
        return instance;
    }

    public  Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/layos","root","1234") ;
        if(connection == null || connection.isClosed()){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/layos","root","1234");
        }
        return  connection;
    }

}
