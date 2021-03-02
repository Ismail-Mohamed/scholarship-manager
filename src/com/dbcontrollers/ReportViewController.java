/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dbcontrollers;

import com.dbconector.DBConnector;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.view.JasperViewer;


import java.sql.Connection;
import java.sql.SQLException;


/**
 * @author ISmaIL
 */

public class ReportViewController {

    public void viewReport(JasperDesign report) throws JRException, ClassNotFoundException, SQLException {

        Connection conn = DBConnector.getDBConnection().getConnection();
        JasperReport jr = JasperCompileManager.compileReport(report);
        JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
        JasperViewer.viewReport(jp, false);

    }
}