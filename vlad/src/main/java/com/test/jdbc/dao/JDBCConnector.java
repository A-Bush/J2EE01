package com.test.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by vladimir on 10.02.16.
 */
public class JDBCConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/test_test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    private JDBCConnector() {
    }

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("Connection is ok!");
        }

        return connection;
    }
}
