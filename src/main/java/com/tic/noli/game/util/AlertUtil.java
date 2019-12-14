package com.tic.noli.game.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


public class AlertUtil {
    public static void showAlert(Alert.AlertType alertType, String message) {
        final Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.show();
    }

    public static ButtonType showAndWaitAlert(Alert.AlertType alertType, String message) {
        final Alert alert = new Alert(alertType);
        alert.setContentText(message);
        return alert
                .showAndWait()
                .orElseThrow(() -> new RuntimeException("button is null"));
    }
}
