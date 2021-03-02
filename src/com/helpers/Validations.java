package com.helpers;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Validations {
    // TODO: add validation to all demands fields

    public static boolean validateEmpty(TextField field) {
        if (field.getText() == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur : Case vide");
            alert.setHeaderText(null);
            alert.setContentText("Remplir tout les champs obligatoires s'il vous plaît..!");
            alert.showAndWait();

            return false;
        }
        return true;
    }

    public static boolean validateFloat(TextField field) {
        if (field.getText().matches("[0-9]+|[0-9]+.[0-9]+")) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur : Type non valide");
            alert.setHeaderText(null);
            alert.setContentText("Un type d'entrée non valide..!");
            alert.showAndWait();

            return false;
        }
    }


    public static boolean validateDate(TextField field) {
        if (field.getText().matches("\\d{4}-\\d{2}-\\d{2}|\\d{2}-\\d{2}-\\d{4}|\\d{4}/\\d{2}/\\d{2}|\\d{2}/\\d{2}/\\d{4}")) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erreur : Date invalide..!");
            alert.setHeaderText(null);
            alert.setContentText("Date invalide..!");
            alert.showAndWait();

            return false;
        }
    }

}
