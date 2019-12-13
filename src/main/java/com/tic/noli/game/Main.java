package com.tic.noli.game;

import com.tic.noli.game.enums.ViewPath;
import com.tic.noli.game.managaer.ViewManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewManager.getInstance()
                .show(ViewPath.VIEW_PATH.getPath(), new Stage());
        exitListener(primaryStage);
    }

    private void exitListener(Stage primaryStage) {
        primaryStage.setOnCloseRequest(event -> {
            if (!event.isConsumed()) {
                final Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                final Optional<ButtonType> optionalButtonType = alert.showAndWait();
                if (optionalButtonType.isPresent()) {
                    final ButtonType button = optionalButtonType.get();
                    if (button == ButtonType.CANCEL) {
                        event.consume();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
