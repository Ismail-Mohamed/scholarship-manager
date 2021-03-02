package com.views.controllers;

import com.dbcontrollers.DemandController;
import com.dbcontrollers.DemandTableController;
import com.dbcontrollers.ReportViewController;
import com.helpers.AlertHelper;
import com.jfoenix.controls.JFXButton;
import com.models.Demand;
import com.tableModels.DemandTableModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ArchiveController implements Initializable {

    @FXML
    private TableView tableArchive;

    @FXML
    private TableColumn<DemandTableModel, String> idColumn;
    @FXML
    private TableColumn<DemandTableModel, String> fullNameFrColumn;
    @FXML
    private TableColumn<DemandTableModel, String> gradeColumn;
    @FXML
    private TableColumn<DemandTableModel, String> beginDateColumn;
    @FXML
    private TableColumn<DemandTableModel, String> hostCountryColumn;
    @FXML
    private TableColumn<DemandTableModel, String> facultyColumn;
    @FXML
    private TableColumn<DemandTableModel, String> financialYearColumn;
    @FXML
    private JFXButton edit;
    @FXML
    private JFXButton delete;
    @FXML
    private JFXButton print;

    private String searchValue;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            prepareArchive(this.searchValue);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        edit.setOnAction(editEvent);
        delete.setOnAction(deletAction);
        print.setOnAction(printEvent);
    }

    public void prepareArchive(String searchValue) throws SQLException, ClassNotFoundException {
        if (searchValue != null) {
            ObservableList<DemandTableModel> demandList = FXCollections
                    .observableArrayList(DemandTableController.fetchAll(searchValue));
            setValueFactory(demandList);
        } else {
            ObservableList<DemandTableModel> demandList = FXCollections
                    .observableArrayList(DemandTableController.fetchAll());
            setValueFactory(demandList);
        }

    }

    private void setValueFactory(ObservableList<DemandTableModel> demandList) {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        fullNameFrColumn.setCellValueFactory(new PropertyValueFactory<>("fullNameFr"));
        gradeColumn.setCellValueFactory(new PropertyValueFactory<>("grade"));
        beginDateColumn.setCellValueFactory(new PropertyValueFactory<>("beginDate"));
        hostCountryColumn.setCellValueFactory(new PropertyValueFactory<>("hostCountry"));
        facultyColumn.setCellValueFactory(new PropertyValueFactory<>("faculty"));
        financialYearColumn.setCellValueFactory(new PropertyValueFactory<>("financialYear"));
        tableArchive.setItems(demandList);
    }

    @FXML
    EventHandler<ActionEvent> deletAction = e -> {
        DemandTableModel selectedItem = (DemandTableModel) tableArchive.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            int resultQuery = 0;
            try {
                resultQuery = DemandController.delete(selectedItem.getId());
                if (resultQuery > 0) {
                    prepareArchive(this.searchValue);
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        } else {
            AlertHelper.makeAlert("Erreur ...! ", "vous devez choisissez une ligne");
        }
    };

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    @FXML
    EventHandler<ActionEvent> editEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent actionEvent) {
            DemandTableModel selectedItem = (DemandTableModel) tableArchive.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                Demand demand = null;
                try {
                    demand = DemandController.fetch(selectedItem.getId());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Scene scene = ((Node) actionEvent.getSource()).getScene();
                BorderPane borderPane = (BorderPane) scene.getRoot();
                FXMLLoader candidatePage = new FXMLLoader(getClass().getResource("../fxml/candidats.fxml"));
                CandidateController candidateController = new CandidateController();
                if (demand != null) {
                    candidateController.setId(demand.getId());
                    candidateController.setGender(demand.getGender());
                    candidateController.setFullNameFr(demand.getFullNameFr());
                    candidateController.setFullNameAr(demand.getFullNameAr());
                    candidateController.setBudget(demand.getBudget());
                    candidateController.setTicketPrice(demand.getTicketPrice());
                    candidateController.setScholarshipType(demand.getScholarshipType());
                    candidateController.setDob(demand.getDob());
                    candidateController.setBeneficiary(demand.getBeneficiary());
                    candidateController.setDomain(demand.getDomain());
                    candidateController.setBeginDate(demand.getBeginDate());
                    candidateController.setGrade(demand.getGrade());
                    candidateController.setFaculty(demand.getFaculty());
                    candidateController.setEndDate(demand.getEndDate());
                    candidateController.setDuration(demand.getDuration());
                    candidateController.setCountry(demand.getHostCountry());
                    candidateController.setLaboratory(demand.getHostLaboratory());
                    candidateController.setFinancialYear(demand.getFinancialYear());
                    candidateController.setEditTextButton("Modifier");
                }

                candidatePage.setController(candidateController);
                try {
                    borderPane.setCenter(candidatePage.load());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // TODO: alert handler needed
                AlertHelper.makeAlert("Erreur ...! ", "vous devez choisissez une ligne");
            }
        }
    };
    @FXML
    EventHandler<ActionEvent> printEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            DemandTableModel selectedItem = (DemandTableModel) tableArchive.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                try {
                    InputStream report = getClass().getResourceAsStream("/com/reports/demandReport.jrxml");
                    JRDesignQuery query = new JRDesignQuery();
                    // bloc code for report view
                    if (report != null) {
                        JasperDesign jd = JRXmlLoader.load(report);
                        query.setText("SELECT * FROM demands WHERE id = '" + selectedItem.getId() + "'");
                        jd.setQuery(query);
                        ReportViewController r = new ReportViewController();
                        r.viewReport(jd);
                    }
                } catch (JRException | SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }

            }
        }
    };
}