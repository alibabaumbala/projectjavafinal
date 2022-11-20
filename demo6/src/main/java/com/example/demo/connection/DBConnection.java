package com.example.demo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    public static Connection getConnection()
    {
        String url = "jdbc:mysql://localhost:3306/java-final";
        String user = "root";
        String password = "";
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, user, password);
            return conn;
        }catch (ClassNotFoundException e)
        {

        }catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        finally {
            return conn;
        }
    }

}
