package com.tic.noli.game.listeners;

import com.tic.noli.game.util.AlertUtil;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class StageExitListener implements Listener {

    private final String message = "Are you sure that you want to exit?";
    private final Stage stage;
    private boolean isEnable = true;


    public StageExitListener(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void start() {
        stage.setOnCloseRequest(event -> {
            if (isEnable) {
                if (!event.isConsumed()) {
                    final ButtonType buttonType = AlertUtil.showAndWaitAlert(Alert.AlertType.CONFIRMATION, message);
                    if (buttonType == ButtonType.CANCEL) {
                        event.consume();
                    }
                }
            }
        });
    }

    @Override
    public void stop() {
       this.isEnable = false;
    }

    @Override
    public boolean isEnable() {
        return isEnable;
    }
}
