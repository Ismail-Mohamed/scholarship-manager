package com.views.controllers;

import com.jfoenix.controls.JFXButton;
import com.helpers.DragPageH;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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
import javafx.stage.Stage;
import com.main.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable  {


    public VBox pnItems;
    public JFXButton logOut;
    public AnchorPane topBar;
    @FXML
    private BorderPane borderPane;

    @FXML
    private ListView<?> listMenu;


    @FXML
    private Button minimize;


    @FXML
    private Button close;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DragPageH.MakeDraggable(topBar);
        try {
            loadUI("../fxml/stats") ;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadUI(String ui) throws IOException {
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        borderPane.setCenter(root);
    }

    public void getCandidatePage(ActionEvent actionEvent) throws IOException {
        loadUI("../fxml/candidats");
    }

    public void getArchivePage(ActionEvent actionEvent) throws IOException {
        loadUI("../fxml/archive");
    }

    public void getStatsPage(ActionEvent actionEvent) throws IOException {
        loadUI("../fxml/stats");
    }

    public void getLaboPage(ActionEvent actionEvent) throws IOException {
        loadUI("../fxml/laboratoire");
    }

    public void logOutUser(ActionEvent actionEvent) throws IOException {
        Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent loginPage = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        s.setScene(new Scene(loginPage));
        Main.stage = s; // send current stage
        s.show();
    }


    public void hideProgram(ActionEvent actionEvent) {
        Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        s.setIconified(true);
    }

    public void maximizeProgram(ActionEvent actionEvent) {
        //TODO: make a resizeable border pane
    }

    public void closeProgram(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }


}


