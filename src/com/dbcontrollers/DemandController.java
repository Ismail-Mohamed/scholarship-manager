package com.dbcontrollers;

import com.dbconector.DBConnector;
import com.models.Demand;

import java.sql.*;
import java.util.ArrayList;

public class DemandController {

    public static int create(Demand demand) throws SQLException, ClassNotFoundException {
        String SQL = "INSERT INTO demands (beneficiary, fullNameAr, fullNameFr, dob, gender, Grade, duration, beginDate, endDate, hostCountry, hostLaboratory, domain, scholarshipType, budget, ticketPrice, financialYear, Faculty) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);

        return setPlaceHolder(demand, stm);
    }

    private static int setPlaceHolder(Demand demand, PreparedStatement stm) throws SQLException {
        stm.setObject(1, demand.getBeneficiary());
        stm.setObject(2, demand.getFullNameAr());
        stm.setObject(3, demand.getFullNameFr());
        stm.setObject(4, demand.getDob());
        stm.setObject(5, demand.getGender());
        stm.setObject(6, demand.getGrade());
        stm.setObject(7, demand.getDuration());
        stm.setObject(8, demand.getBeginDate());
        stm.setObject(9, demand.getEndDate());
        stm.setObject(10, demand.getHostCountry());
        stm.setObject(11, demand.getHostLaboratory());
        stm.setObject(12, demand.getDomain());
        stm.setObject(13, demand.getScholarshipType());
        stm.setObject(14, demand.getBudget());
        stm.setObject(15, demand.getTicketPrice());
        stm.setObject(16, demand.getFinancialYear());
        stm.setObject(17, demand.getFaculty());

        return stm.executeUpdate();
    }

    public static Demand fetch(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM demands WHERE id = ? ";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst = stm.executeQuery();
        if (rst.next()) {
            return new Demand(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getLong(8), rst.getString(9), rst.getString(10), rst.getString(11), rst.getString(12), rst.getString(13), rst.getString(14), rst.getString(15), rst.getString(16), rst.getString(17), rst.getString(18));
        }
        return null;
    }

    public static ArrayList<Demand> fetchAll() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnector.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM demands");
        ArrayList<Demand> demandList = new ArrayList<>();
        while (rst.next()) {
            Demand demand = new Demand(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getLong(8), rst.getString(9), rst.getString(10), rst.getString(11), rst.getString(12), rst.getString(13), rst.getString(14), rst.getString(15), rst.getString(16), rst.getString(17), rst.getString(18));
            demandList.add(demand);
        }
        return demandList;
    }

    public static int update(Demand demand) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE demands SET beneficiary=?, fullNameFr=?, fullNameAr=?, dob=?, gender=?, Grade=?, duration=?, beginDate=?, endDate=?, hostCountry=?, hostLaboratory=?, domain=?, scholarshipType=?, budget=?, ticketPrice=?, financialYear=?, Faculty=? WHERE id ='" + demand.getId() + "'";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return setPlaceHolder(demand, stm);
    }

    public static int delete(String id) throws SQLException, ClassNotFoundException {
        //TODO: make table deleted demands to move deleted items in it
        String sql = "DELETE FROM demands WHERE id = ? ";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);

        return stm.executeUpdate();
    }


}
