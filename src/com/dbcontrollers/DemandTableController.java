package com.dbcontrollers;

import com.dbconector.DBConnector;
import com.tableModels.DemandTableModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DemandTableController {

    public static ArrayList<DemandTableModel> fetchAll() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnector.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM demands");
        ArrayList<DemandTableModel> demandList = new ArrayList<>();
        while (rst.next()) {
            DemandTableModel demandModel = new DemandTableModel(rst.getString("id"), rst.getString("fullNameFr"), rst.getString("grade"), rst.getString("beginDate"), rst.getString("hostCountry"), rst.getString("faculty"), rst.getString("financialYear"));
            demandList.add(demandModel);
        }
        return demandList;
    }

    public static ArrayList<DemandTableModel> fetchAll(String name) throws SQLException, ClassNotFoundException {
        Connection conn = DBConnector.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("SELECT * FROM demands WHERE fullNameFr LIKE '" + name + "%'");
        ArrayList<DemandTableModel> demandList = new ArrayList<>();
        while (rst.next()) {
            DemandTableModel demandModel = new DemandTableModel(rst.getString("id"), rst.getString("fullNameFr"), rst.getString("grade"), rst.getString("beginDate"), rst.getString("hostCountry"), rst.getString("faculty"), rst.getString("financialYear"));
            demandList.add(demandModel);
        }
        return demandList;
    }

}
