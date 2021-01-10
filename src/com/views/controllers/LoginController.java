package com.views.controllers;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import com.helpers.DragPageH;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import com.main.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    public JFXTextField emailField;
    public JFXPasswordField passwordField;
    public Button close;
    public AnchorPane mainAnchorPane;
    public JFXButton rememberCheck;
    public FontAwesomeIcon checkIcon;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DragPageH.MakeDraggable(mainAnchorPane);
    }


    public void getHomePage(ActionEvent actionEvent) throws IOException {
        String emailFieldText = emailField.getText();
        String passwordFieldText = passwordField.getText();

        if (emailFieldText.equals("email@email.com") && passwordFieldText.equals("password")) {
            Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            Parent homePage = FXMLLoader.load(getClass().getResource("../fxml/homePage.fxml"));
            s.setScene(new Scene(homePage));
            Main.stage = s; // send current stage
            s.setX(200);
            s.setY(200);
            s.show();
        }

    }


    public void getSignUpPage(ActionEvent actionEvent) throws IOException {
        Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent signupPage = FXMLLoader.load(getClass().getResource("../fxml/signup.fxml"));
        s.setScene(new Scene(signupPage));
        Main.stage = s; // send current stage
        s.show();
    }

    public void rememberCheck(ActionEvent actionEvent) {
        checkIcon.setVisible(!checkIcon.isVisible());
    }

    public void closeProgram(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }
}

