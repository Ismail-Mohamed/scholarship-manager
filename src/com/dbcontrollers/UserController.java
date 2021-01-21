package com.dbcontrollers;

import com.dbconector.DBConnector;

import com.interfaces.IUser;
import com.models.User;

import java.sql.*;
import java.util.ArrayList;

public class UserController implements IUser {

    //TODO: hash password logic should be required in this controller
    @Override
    public int create(User user) throws SQLException, ClassNotFoundException {
        String SQL = "INSERT INTO users VALUES(?,?,?)";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);

        stm.setObject(1, user.getUsername());
        stm.setObject(2, user.getEmail());
        stm.setObject(3, user.getPassword());

        return stm.executeUpdate();
    }

    @Override
    public User fetch(String email) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM users WHERE email = ? ";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, email);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return new User(rst.getString(1), rst.getString(2), rst.getString(3));
        }
        return null;
    }

    @Override
    public ArrayList<User> fetchAll() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnector.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("Select * From users");
        ArrayList<User> userList = new ArrayList<>();
        while (rst.next()) {
            User user = new User(rst.getString(1), rst.getString(2), rst.getString(3));
            userList.add(user);
        }
        return userList;
    }

    @Override
    public int update(User user) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE users SET username= ? ,email=? ,password= ?  WHERE email= '" + user.getEmail() + "'";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, user.getUsername());
        stm.setObject(2, user.getEmail());
        stm.setObject(3, user.getPassword());

        return stm.executeUpdate();
    }

    @Override
    public int delete(String email) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM users WHERE email = ? ";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, email);

        return stm.executeUpdate();
    }
}
