package com.dbcontrollers;

import com.dbconector.DBConnector;
import com.tableModels.StatTableModel;
import javafx.beans.Observable;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class DBStatController {
    public static ArrayList<StatTableModel> getStats(String entityColumn, long currentYear) throws SQLException, ClassNotFoundException {
        long[] years = {currentYear, currentYear - 1, currentYear - 2, currentYear - 3, currentYear - 4};
        String sql = "SELECT " + entityColumn + ",sum(CASE financialYear WHEN '" + years[4] + "' THEN 1 ELSE NULL END) AS '" + years[4] + "', sum(CASE financialYear WHEN '" + years[3] + "' THEN 1 ELSE NULL END) AS '" + years[3] + "', sum(CASE financialYear WHEN '" + years[2] + "' THEN 1 ELSE NULL END) AS '" + years[2] + "', sum(CASE financialYear WHEN '" + years[1] + "' THEN 1 ELSE NULL END) AS '" + years[1] + "', sum(CASE financialYear WHEN '" + years[0] + "' THEN 1 ELSE NULL END) AS '" + years[0] + "', sum(CASE WHEN " + entityColumn + "=" + entityColumn + " and demands.financialYear in (?,?,?,?,?) then 1 ELSE 0 END) AS 'Total général' FROM demands group by " + entityColumn + " order by `Total général` desc";
        Connection conn = DBConnector.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, years[0]);
        stm.setObject(2, years[1]);
        stm.setObject(3, years[2]);
        stm.setObject(4, years[3]);
        stm.setObject(5, years[4]);
        ResultSet rst = stm.executeQuery();
        ArrayList<StatTableModel> tableList = new ArrayList<>();
        while (rst.next()) {
            StatTableModel statItemRow = new StatTableModel(rst.getString(1), rst.getInt(2), rst.getInt(3), rst.getInt(4), rst.getInt(5), rst.getInt(6), rst.getInt(7));
            tableList.add(statItemRow);
        }
        return tableList;
    }

    public static ObservableList<StatTableModel> totalCalculation(ObservableList<StatTableModel> list) {
        int total1 = 0, total2 = 0, total3 = 0, total4 = 0, total5 = 0, total6 = 0;
        for (StatTableModel item : list) {
            total5 += item.getYear1();
            total4 += item.getYear2();
            total1 += item.getYear5();
            total3 += item.getYear3();
            total2 += item.getYear4();
            total6 += item.getTotal();
        }
        list.add(new StatTableModel("Total", total1, total2, total3, total4, total5, total6));
        return list;
    }
}

