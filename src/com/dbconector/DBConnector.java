package com.dbconector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private Connection conn;
    private static DBConnector dbConn;

    private final String USERNAME = "root";
    private final String PASSWORD = "12345";
    private final String HOSTNAME = "localhost:3306";
    private final String DBNAME = "scholarship";
    private final String URL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;

    private DBConnector() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public Connection getConnection() {
        return conn;
    }

    // constructor
    public static DBConnector getDBConnection() throws ClassNotFoundException, SQLException {
        if (dbConn == null) {
            dbConn = new DBConnector();
        }
        return dbConn;
    }
}
