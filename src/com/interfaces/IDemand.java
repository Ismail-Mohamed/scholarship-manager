package com.interfaces;

import com.models.Demand;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IDemand {
    // all crud operation should be include in IUser
    int create(Demand demand) throws SQLException, ClassNotFoundException;

    Demand fetch(int id) throws SQLException, ClassNotFoundException;

    ArrayList<Demand> fetchAll() throws SQLException, ClassNotFoundException;

    int update(Demand demand) throws SQLException, ClassNotFoundException;

    int delete(int id) throws SQLException, ClassNotFoundException;
}
