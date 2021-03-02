package com.views.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TableRowController implements Initializable {
    public javafx.scene.layout.HBox HBox;

    @FXML
    private Label idField;

    @FXML
    private Label fullNameField;

    @FXML
    private Label typeField;

    @FXML
    private Label dateField;

    @FXML
    private Label countryField;


    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXButton editButton;

    @FXML
    private JFXButton printButton;

    private String id;
    private String fullName;
    private String type;
    private String date;
    private String country;
    private boolean backgroundColor;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (backgroundColor)
            HBox.setStyle("-fx-background-color: #f7f7f7;");
        idField.setText(id);
        fullNameField.setText(fullName);
        typeField.setText(type);
        dateField.setText(date);
        countryField.setText(country);
        editButton.setOnAction(edit);
        deleteButton.setOnAction(delete);
        printButton.setOnAction(print);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public void setBackgroundColor(boolean backgroundColor) {
        this.backgroundColor = backgroundColor;
    }


    public String getId() {
        return id;
    }

    EventHandler<ActionEvent> edit = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            System.out.println(id);
        }
    };
    EventHandler<ActionEvent> delete = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            System.out.println(fullName);
        }
    };
    EventHandler<ActionEvent> print = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            System.out.println(date);
        }
    };
}
