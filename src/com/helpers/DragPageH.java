package com.helpers;

import javafx.scene.layout.AnchorPane;
import com.main.Main;


public class DragPageH {

    public static double x;
    public static double y;

    public static void MakeDraggable(AnchorPane anchorPane) {

        anchorPane.setOnMousePressed((event) -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        anchorPane.setOnMouseDragged((event) -> {
            Main.stage.setX(event.getScreenX() - x);
            Main.stage.setY(event.getScreenY() - y);
            Main.stage.setOpacity(0.6f);
        });
        anchorPane.setOnDragDone((event) -> {
            Main.stage.setOpacity(1.0f);
        });
        anchorPane.setOnMouseReleased((event) -> {
            Main.stage.setOpacity(1.0f);
        });
    }

}
