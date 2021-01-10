package com.dbconector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static Connection conn;
    private static DBConnector dbConn;

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static  final String HOSTNAME = "localhost:3306";
    private static final String DBNAME = "ihmMiniProjet";
    private static final String URL = "jdbc:mysql://" + HOSTNAME + "/" + DBNAME;

    private DBConnector()throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
    public Connection getConnection(){
        return conn;
    }
    // constructor
    public static DBConnector getDBConnection()throws ClassNotFoundException,SQLException{
        if(dbConn==null){
            dbConn =new DBConnector();
        }
        return dbConn;
    }
}
