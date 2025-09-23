package com.mrudul.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String url = "jdbc:postgresql://localhost:5432/expense_db";
    private static final String user ="postgres";
    private static final String pwd = "000";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(url,user,pwd);
        return connection;
    }
}
