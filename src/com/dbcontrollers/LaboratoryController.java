package com.dbcontrollers;

import com.dbconector.DBConnector;
import com.interfaces.ILaboratory;
import com.models.Laboratory;

import java.sql.*;
import java.util.ArrayList;

public class LaboratoryController implements ILaboratory {

    @Override
    public int create(Laboratory laboratory) throws SQLException, ClassNotFoundException {
        String SQL = "INSERT INTO laboratories (name ,region ,country ,town ,city ,zipCode ,address ,phone ,email ,website) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);

        stm.setObject(1, laboratory.getName());
        stm.setObject(2, laboratory.getRegion());
        stm.setObject(3, laboratory.getWebsite());
        stm.setObject(4, laboratory.getTow());
        stm.setObject(5, laboratory.getCity());
        stm.setObject(6, laboratory.getZipCode());
        stm.setObject(7, laboratory.getAddress());
        stm.setObject(8, laboratory.getPhone());
        stm.setObject(9, laboratory.getEmail());
        stm.setObject(10, laboratory.getCountry());

        return stm.executeUpdate();
    }

    @Override
    public Laboratory fetch(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM laboratories WHERE id = ? ";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return new Laboratory(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11));
        }
        return null;
    }

    @Override
    public ArrayList<Laboratory> fetchAll() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnector.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("Select * From laboratories");
        ArrayList<Laboratory> laboratoriesList = new ArrayList<>();
        while (rst.next()) {
            Laboratory laboratory = new Laboratory(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11));
            laboratoriesList.add(laboratory);
        }
        return laboratoriesList;
    }

    @Override
    public int update(Laboratory laboratory) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE laboratories SET name=? ,region=? ,country=? ,town=? ,city=? ,zipCode=? ,address=? ,phone=? ,email=? ,website=? WHERE id= "+laboratory.getId()+"";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setObject(1, laboratory.getName());
        stm.setObject(2, laboratory.getRegion());
        stm.setObject(3, laboratory.getWebsite());
        stm.setObject(4, laboratory.getTow());
        stm.setObject(5, laboratory.getCity());
        stm.setObject(6, laboratory.getZipCode());
        stm.setObject(7, laboratory.getAddress());
        stm.setObject(8, laboratory.getPhone());
        stm.setObject(9, laboratory.getEmail());
        stm.setObject(10, laboratory.getCountry());

        return stm.executeUpdate();
    }

    @Override
    public int delete(String id) throws SQLException, ClassNotFoundException {
        //TODO: make table deleted demands to move deleted items in it
        String sql = "DELETE FROM laboratories WHERE id = ? ";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);

        return stm.executeUpdate();
    }
}
