package com.dbcontrollers;

import com.dbconector.DBConnector;
import com.interfaces.IDemand;
import com.models.Demand;

import java.sql.*;
import java.util.ArrayList;

public class DemandController implements IDemand {

    @Override
    public int create(Demand demand) throws SQLException, ClassNotFoundException {
        String SQL = "INSERT INTO demands (firstName, firstNameAr, lastName, lastNameAr, gender, dob, dobLocation, scholarshipBeginDate, scholarshipEndDate, address, email, phoneNumberOne, phoneNumberTow, scholarshipCountry, scholarshipLaboratory, domain, scholarshipType, scholarshipAmount, ticketPrice, faculty, year, department, acknowledgement) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);

        stm.setObject(1, demand.getFirstName());
        stm.setObject(2, demand.getFirstNameAr());
        stm.setObject(3, demand.getLastName());
        stm.setObject(4, demand.getLastNameAr());
        stm.setObject(5, demand.getGender());
        stm.setObject(6, demand.getDob());
        stm.setObject(7, demand.getDobLocation());
        stm.setObject(8, demand.getScholarshipBeginDate());
        stm.setObject(9, demand.getScholarshipEndDate());
        stm.setObject(10, demand.getAddress());
        stm.setObject(11, demand.getEmail());
        stm.setObject(12, demand.getPhoneNumberOne());
        stm.setObject(13, demand.getPhoneNumberTow());
        stm.setObject(14, demand.getScholarshipCountry());
        stm.setObject(15, demand.getScholarshipLaboratory());
        stm.setObject(16, demand.getDomain());
        stm.setObject(17, demand.getScholarshipType());
        stm.setObject(18, demand.getScholarshipAmount());
        stm.setObject(19, demand.getTicketPrice());
        stm.setObject(20, demand.getFaculty());
        stm.setObject(21, demand.getYear());
        stm.setObject(22, demand.getDepartment());
        stm.setObject(23, demand.isAcknowledgement());

        return stm.executeUpdate();
    }

    @Override
    public Demand fetch(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM demands WHERE id = ? ";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return new Demand(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11), rst.getString(12), rst.getString(13), rst.getString(14), rst.getString(15), rst.getString(16), rst.getString(17), rst.getString(18), rst.getString(19), rst.getString(20), rst.getString(21), rst.getString(22), rst.getString(23), rst.getBoolean(24));
        }
        return null;
    }

    @Override
    public ArrayList<Demand> fetchAll() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnector.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("Select * From demands");
        ArrayList<Demand> demandList = new ArrayList<>();
        while (rst.next()) {
            Demand demand = new Demand(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11), rst.getString(12), rst.getString(13), rst.getString(14), rst.getString(15), rst.getString(16), rst.getString(17), rst.getString(18), rst.getString(19), rst.getString(20), rst.getString(21), rst.getString(22), rst.getString(23), rst.getBoolean(24));
            demandList.add(demand);
        }
        return demandList;
    }

    @Override
    public int update(Demand demand) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE demands SET firstName=? ,firstNameAr=?, lastName=?, lastNameAr=?, gender=?, dob=?, dobLocation=?, scholarshipBeginDate=?, scholarshipEndDate=?, address=?, email=?, phoneNumberOne=?, phoneNumberTow=?, scholarshipCountry=?, scholarshipLaboratory=?, domain=?, scholarshipType=?, scholarshipAmount=?, ticketPrice=?, faculty=?, year=?, department=?, acknowledgement=? WHERE id= "+demand.getId()+"";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setObject(1, demand.getFirstName());
        stm.setObject(2, demand.getFirstNameAr());
        stm.setObject(3, demand.getLastName());
        stm.setObject(4, demand.getLastNameAr());
        stm.setObject(5, demand.getGender());
        stm.setObject(6, demand.getDob());
        stm.setObject(7, demand.getDobLocation());
        stm.setObject(8, demand.getScholarshipBeginDate());
        stm.setObject(9, demand.getScholarshipEndDate());
        stm.setObject(10, demand.getAddress());
        stm.setObject(11, demand.getEmail());
        stm.setObject(12, demand.getPhoneNumberOne());
        stm.setObject(13, demand.getPhoneNumberTow());
        stm.setObject(14, demand.getScholarshipCountry());
        stm.setObject(15, demand.getScholarshipLaboratory());
        stm.setObject(16, demand.getDomain());
        stm.setObject(17, demand.getScholarshipType());
        stm.setObject(18, demand.getScholarshipAmount());
        stm.setObject(19, demand.getTicketPrice());
        stm.setObject(20, demand.getFaculty());
        stm.setObject(21, demand.getYear());
        stm.setObject(22, demand.getDepartment());
        stm.setObject(23, demand.isAcknowledgement());
        stm.setObject(24, demand.getId());

        return stm.executeUpdate();
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        //TODO: make table deleted demands to move deleted items in it
        String sql = "DELETE FROM demands WHERE id = ? ";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);

        return stm.executeUpdate();
    }


}
