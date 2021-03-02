package com.views.controllers;

import com.helpers.AlertHelper;
import com.importFile.ImportFile;
import com.jfoenix.controls.JFXButton;
import com.helpers.DragPageH;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import com.main.Main;
import jxl.read.biff.BiffException;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {


    public AnchorPane topBar;
    public JFXButton importButton;

    @FXML
    private JFXButton statsPageButton;
    @FXML
    private JFXButton candidatePageButton;
    @FXML
    private JFXButton archivePageButton;
    @FXML
    private JFXButton logOutButton;
    @FXML
    private JFXTextField searchField;
    @FXML
    private BorderPane borderPane;

    @FXML
    private JFXButton searchButton;

    @FXML
    private Button minimize;


    @FXML
    private Button close;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DragPageH.MakeDraggable(topBar);
        searchButton.setOnAction(searchEvent);
        statsPageButton.setOnAction(getStatsPage);
        candidatePageButton.setOnAction(getCandidatePage);
        archivePageButton.setOnAction(getArchivePage);
        logOutButton.setOnAction(logOutUser);
        close.setOnAction(closeProgram);
        minimize.setOnAction(hideProgram);
        getStatsPage.handle(new ActionEvent());
        importButton.setOnAction(importEvent);
    }

    @FXML
    EventHandler<ActionEvent> getCandidatePage = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            Parent root = null;
            FXMLLoader candidatePage = new FXMLLoader(getClass().getResource("../fxml/candidats.fxml"));
            candidatePage.setController(new CandidateController());
            try {
                borderPane.setCenter(candidatePage.load());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    };

    @FXML
    EventHandler<ActionEvent> getArchivePage = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            Parent root = null;
            FXMLLoader archivePage = new FXMLLoader(getClass().getResource("../fxml/archive.fxml"));
            archivePage.setController(new ArchiveController());
            try {
                borderPane.setCenter(archivePage.load());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    };
    @FXML
    EventHandler<ActionEvent> getStatsPage = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../fxml/stats.fxml"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            borderPane.setCenter(root);
        }
    };


    @FXML
    EventHandler<ActionEvent> logOutUser = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent actionEvent) {
            Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent loginPage = null;
            try {
                loginPage = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            s.setScene(new Scene(loginPage));
            Main.stage = s; // send current stage
            s.show();
        }
    };


    @FXML
    EventHandler<ActionEvent> hideProgram = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent actionEvent) {
            Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            s.setIconified(true);
        }
    };


    public void maximizeProgram(ActionEvent actionEvent) {
        //TODO: make a resizeable border pane
    }

    @FXML
    EventHandler<ActionEvent> closeProgram = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            Platform.exit();
            System.exit(0);
        }
    };

    @FXML
    EventHandler<ActionEvent> searchEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent actionEvent) {

            Scene scene = (Scene) ((Node) actionEvent.getSource()).getScene();
            BorderPane borderPane = (BorderPane) scene.getRoot();
            FXMLLoader archivePage = new FXMLLoader(getClass().getResource("../fxml/archive.fxml"));
            ArchiveController archiveController = new ArchiveController();
            archiveController.setSearchValue(searchField.getText());
            archivePage.setController(archiveController);
            try {
                borderPane.setCenter(archivePage.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    @FXML
    EventHandler<ActionEvent> importEvent = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent actionEvent) {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files(*.xls)", "*.xls");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                ImportFile importFile = new ImportFile();
                try {
                    int request = importFile.importDataFrom(file);
                    if (request > 0) {
                        AlertHelper.makeAlert("Message de réussite", "votre base des données a été ajoutée avec succès");
                        getArchivePage.handle(actionEvent);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (BiffException e) {
                    e.printStackTrace();
                }
            }
        }
    };

}


