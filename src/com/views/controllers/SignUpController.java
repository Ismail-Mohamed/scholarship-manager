package com.views.controllers;

import com.dbcontrollers.UserController;
import com.helpers.AlertHelper;
import com.helpers.Validations;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.models.User;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
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
import javafx.stage.Stage;
import com.main.Main;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {
    public JFXTextField usernameField;
    public Button close;
    public JFXTextField emailField;
    public JFXPasswordField passwordField;
    public AnchorPane mainAnchorPane;
    public FontAwesomeIcon checkIcon;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DragPageH.MakeDraggable(mainAnchorPane);
    }


    public void closeProgram(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }

    public void signUp(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

        String email = emailField.getText();
        String password = passwordField.getText();
        String username = usernameField.getText();
        if (!email.isEmpty() && !password.isEmpty() && !username.isEmpty()) {
            User user = new User(username, email, password);
            int resutl = UserController.create(user);
            if (resutl > 0) {
                Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                Parent loginPage = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
                s.setScene(new Scene(loginPage));
                Main.stage = s; // send current stage
                s.show();
            }

        } else {
            AlertHelper.makeAlert("Sign UP", "Email & Username & Password Required..!");
        }

    }

    public void getLogInPage(ActionEvent actionEvent) throws IOException {
        Stage s = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent loginPage = FXMLLoader.load(getClass().getResource("../fxml/login.fxml"));
        s.setScene(new Scene(loginPage));
        Main.stage = s; // send current stage
        s.show();
    }

    public void checkCondition(ActionEvent actionEvent) {
        checkIcon.setVisible(!checkIcon.isVisible());
    }


}
