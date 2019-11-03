package sample.util;

import javafx.scene.control.Alert;

public class AlertUtil {
    public static void showAlert(Alert.AlertType alertType, String message){
        final Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.show();
    }
}
