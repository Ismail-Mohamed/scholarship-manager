package com.interfaces;

import com.models.Laboratory;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ILaboratory {
    // all crud operation should be include in IUser
    int create(Laboratory laboratory) throws SQLException, ClassNotFoundException;

    Laboratory fetch(String id) throws SQLException, ClassNotFoundException;

    ArrayList<Laboratory> fetchAll() throws SQLException, ClassNotFoundException;

    int update(Laboratory laboratory) throws SQLException, ClassNotFoundException;

    int delete(String id) throws SQLException, ClassNotFoundException;
}

