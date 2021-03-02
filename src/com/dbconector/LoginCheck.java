package com.dbconector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCheck {
    public static boolean Login(String email, String password) throws SQLException, ClassNotFoundException, SQLException {

        String SQL = "SELECT * FROM users WHERE email=? AND password=?";

        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, email);
        stm.setObject(2, password);
        ResultSet rst = stm.executeQuery();

        if (rst.next()) {

            if (!rst.getString(1).equals(email)) {
                return false;
            }
            String pwd = rst.getString(2);
            if (pwd.equals(password)) {
                return true;
            }
        }
        return false;

    }
}
