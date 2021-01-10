package com.views.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class StatsController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private VBox pnItems;

    public void initialize(URL url, ResourceBundle resourceBundle) {

        Node[] nodes = new Node[5];

        for (int i = 0; i < nodes.length; i++) {
            try {
                if (i == 0)
                    nodes[i] = FXMLLoader.load(getClass().getResource("../fxml/tableHead.fxml"));
                else if (i % 2 == 0)
                    nodes[i] = FXMLLoader.load(getClass().getResource("../fxml/tableRowEven.fxml"));
                else
                    nodes[i] = FXMLLoader.load(getClass().getResource("../fxml/tableRowOdd.fxml"));

                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}