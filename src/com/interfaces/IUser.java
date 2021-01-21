package com.interfaces;

import com.models.User;

import java.sql.SQLException;
import java.util.ArrayList;


public interface IUser {
    // all crud operation should be include in IUser
    int create(User user) throws SQLException, ClassNotFoundException;

    User fetch(String email) throws SQLException, ClassNotFoundException;

    ArrayList<User> fetchAll() throws SQLException, ClassNotFoundException;

    int update(User user) throws SQLException, ClassNotFoundException;

    int delete(String email) throws SQLException, ClassNotFoundException;
}
