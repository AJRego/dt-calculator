package org.ajrego.util;

import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.Parent;
import javafx.stage.Stage;

public interface DraggedScene {

    default void onDraggedScene(Parent root) {
        AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
        AtomicReference<Double> yOffset = new AtomicReference<>((double) 0);

        root.setOnMousePressed(e -> {
            Stage stage = (Stage) root.getScene().getWindow();
            xOffset.set(stage.getX() - e.getScreenX());
            yOffset.set(stage.getY() - e.getScreenY());

        });

        root.setOnMouseDragged(e -> {
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setX(e.getScreenX() + xOffset.get());
            stage.setY(e.getScreenY() + yOffset.get());
            root.setStyle("-fx-cursor: CLOSED_HAND;");
        });

        root.setOnMouseReleased(e -> root.setStyle("-fx-cursor: DEFAULT;"));
    }
}
