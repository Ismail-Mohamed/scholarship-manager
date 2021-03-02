package com.views.controllers;

import com.dbcontrollers.DBStatController;
import com.helpers.AlertHelper;
import com.jfoenix.controls.JFXTextField;
import com.tableModels.StatTableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;

public class StatsController implements Initializable {
    public TableView countryTable;
    public TableColumn countryTableEntity;
    public TableColumn<StatTableModel, String> countryTableColumn2;
    public TableColumn<StatTableModel, String> countryTableColumn3;
    public TableColumn<StatTableModel, String> countryTableColumn4;
    public TableColumn<StatTableModel, String> countryTableColumn5;
    public TableColumn<StatTableModel, String> countryTableColumn6;
    public TableColumn<StatTableModel, String> countryTableTotal;
    public TableView domainsTable;
    public TableColumn domainsTableEntity;
    public TableColumn<StatTableModel, String> domainsTableColumn2;
    public TableColumn<StatTableModel, String> domainsTableColumn3;
    public TableColumn<StatTableModel, String> domainsTableColumn4;
    public TableColumn<StatTableModel, String> domainsTableColumn5;
    public TableColumn<StatTableModel, String> domainsTableColumn6;
    public TableColumn<StatTableModel, String> domainsTableTotal;
    public TableView facultiesTable;
    public TableColumn facultiesTableEntity;
    public TableColumn<StatTableModel, String> facultiesTableColumn2;
    public TableColumn<StatTableModel, String> facultiesTableColumn3;
    public TableColumn<StatTableModel, String> facultiesTableColumn4;
    public TableColumn<StatTableModel, String> facultiesTableColumn5;
    public TableColumn<StatTableModel, String> facultiesTableColumn6;
    public TableColumn<StatTableModel, String> facultiesTableTotal;
    public TableView gradesTable;
    public TableColumn gradesTableEntity;
    public TableColumn<StatTableModel, String> gradesTableColumn2;
    public TableColumn<StatTableModel, String> gradesTableColumn3;
    public TableColumn<StatTableModel, String> gradesTableColumn4;
    public TableColumn<StatTableModel, String> gradesTableColumn5;
    public TableColumn<StatTableModel, String> gradesTableColumn6;
    public TableColumn<StatTableModel, String> gradesTableTotal;
    public JFXTextField yearOfSatat;

    long year = Calendar.getInstance().get(Calendar.YEAR);

    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            intializeTables();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void prepareTable(long currentYear, String queryColumnName, TableView table, TableColumn entityColumn,
            TableColumn column2, TableColumn column3, TableColumn column4, TableColumn column5, TableColumn column6,
            TableColumn totalColumn) throws SQLException, ClassNotFoundException {
        long[] years = { currentYear, currentYear - 1, currentYear - 2, currentYear - 3, currentYear - 4 };
        column2.setText(String.valueOf(years[4]));
        column3.setText(String.valueOf(years[3]));
        column4.setText(String.valueOf(years[2]));
        column5.setText(String.valueOf(years[1]));
        column6.setText(String.valueOf(years[0]));
        ObservableList<StatTableModel> list = FXCollections
                .observableArrayList(DBStatController.getStats(queryColumnName, currentYear));
        ObservableList<StatTableModel> finalList = DBStatController.totalCalculation(list);
        entityColumn.setCellValueFactory(new PropertyValueFactory<>("entity"));
        column2.setCellValueFactory(new PropertyValueFactory<>("year5"));
        column3.setCellValueFactory(new PropertyValueFactory<>("year4"));
        column4.setCellValueFactory(new PropertyValueFactory<>("year3"));
        column5.setCellValueFactory(new PropertyValueFactory<>("year2"));
        column6.setCellValueFactory(new PropertyValueFactory<>("year1"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        table.setItems(finalList);
    }

    public void statGenerator(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        long imputYear = Long.valueOf(yearOfSatat.getText());
        if (imputYear <= year) {
            year = imputYear;
            intializeTables();
        } else {
            AlertHelper.makeAlert("Erreur ..!!",
                    "Votre saisie est incorrect l'année de Promo doit être inférieur a l'année curent ");
        }
    }

    private void intializeTables() throws SQLException, ClassNotFoundException {
        prepareTable(year, "hostCountry", countryTable, countryTableEntity, countryTableColumn2, countryTableColumn3,
                countryTableColumn4, countryTableColumn5, countryTableColumn6, countryTableTotal);
        prepareTable(year, "domain", domainsTable, domainsTableEntity, domainsTableColumn2, domainsTableColumn3,
                domainsTableColumn4, domainsTableColumn5, domainsTableColumn6, domainsTableTotal);
        prepareTable(year, "faculty", facultiesTable, facultiesTableEntity, facultiesTableColumn2,
                facultiesTableColumn3, facultiesTableColumn4, facultiesTableColumn5, facultiesTableColumn6,
                facultiesTableTotal);
        prepareTable(year, "grade", gradesTable, gradesTableEntity, gradesTableColumn2, gradesTableColumn3,
                gradesTableColumn4, gradesTableColumn5, gradesTableColumn6, gradesTableTotal);
    }
}