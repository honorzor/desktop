package com.tic.noli.game.managaer;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewManager {
    private static ViewManager viewManager = null;

    private ViewManager() {
    }

    private Stage lastStage = null;

    public static ViewManager getInstance() {
        if (viewManager == null) {
            synchronized (ViewManager.class) {
                viewManager = new ViewManager();
                return viewManager;
            }
        }
        return viewManager;
    }

    public void show(String path, Stage stage) {
        try {
            final Parent root = FXMLLoader.load(getClass().getResource(path));
            stage.setTitle("Tic-Noil");
            stage.setScene(new Scene(root, 800, 400));
            stage.show();
            this.lastStage = stage;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAndLastClose(String path, Stage stage) {
        if (lastStage != null) {
            lastStage.close();
        }
        show(path, stage);
    }
}
