package com.tic.noli.game.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class ListenerUtil {
    private final static String CONFIRMATION_MESSAGE = "Are yoy sure that you want to exit";

    public static void exitListener(Stage stage) {
        stage.setOnCloseRequest(event -> {
            if (!event.isConsumed()) {
                final ButtonType buttonType = AlertUtil.showAndWaitAlert(Alert.AlertType.CONFIRMATION, CONFIRMATION_MESSAGE);
                if (buttonType == ButtonType.CANCEL) {
                    event.consume();
                }
            }
        });
    }
}
