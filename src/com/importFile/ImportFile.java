package com.importFile;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;

import com.helpers.DateHelper;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import com.dbconector.DBConnector;

import java.sql.SQLException;


public class ImportFile {
    public int importDataFrom(File file) throws IOException, SQLException, ClassNotFoundException, ParseException, BiffException {
        Workbook wb = Workbook.getWorkbook(file);
        Sheet sheet = wb.getSheet(0);
        int Rows = sheet.getRows();
        int restult = -1;
        for (int n = 1; n < Rows; n++) {
            String query = "INSERT INTO demands (beneficiary, fullNameAr, fullNameFr, dob, gender, Grade, duration, beginDate, endDate, hostCountry, hostLaboratory, domain, scholarshipType, budget, ticketPrice, financialYear, Faculty) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection conn = DBConnector.getDBConnection().getConnection();
            PreparedStatement stm = conn.prepareStatement(query);

            stm.setObject(1, sheet.getCell(0, n).getContents());
            stm.setObject(2, sheet.getCell(1, n).getContents());
            stm.setObject(3, sheet.getCell(2, n).getContents());
            stm.setObject(4, DateHelper.format(sheet.getCell(3, n).getContents()));
            stm.setObject(5, sheet.getCell(4, n).getContents());
            stm.setObject(6, sheet.getCell(5, n).getContents());
            stm.setObject(7, sheet.getCell(6, n).getContents());
            stm.setObject(8, DateHelper.format(sheet.getCell(7, n).getContents()));
            stm.setObject(9, DateHelper.format(sheet.getCell(8, n).getContents()));
            stm.setObject(10, sheet.getCell(9, n).getContents());
            stm.setObject(11, sheet.getCell(10, n).getContents());
            stm.setObject(12, sheet.getCell(11, n).getContents());
            stm.setObject(13, sheet.getCell(12, n).getContents());
            stm.setObject(14, sheet.getCell(13, n).getContents());
            stm.setObject(15, sheet.getCell(14, n).getContents());
            stm.setObject(16, sheet.getCell(15, n).getContents());
            stm.setObject(17, sheet.getCell(16, n).getContents());

            restult = stm.executeUpdate();

        }
        if (restult > 1) return 1;
        else return restult;
    }


}

