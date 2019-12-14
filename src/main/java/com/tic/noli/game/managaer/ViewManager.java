package com.tic.noli.game.managaer;

import com.tic.noli.game.util.ListenerUtil;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewManager {
    private static ViewManager viewManager = null;
    private final static String TITTLE_NAME = "Tic-Noil";
    private final static int DEFAULT_WIDTH = 800;
    private final static int DEFAULT_HEIGHT = 400;

    private ViewManager() {
    }

    private Stage lastStage = null;

    public synchronized static ViewManager getInstance() {
        if (viewManager == null) {
            viewManager = new ViewManager();
            return viewManager;
        }
        return viewManager;
    }

    public void showWithStage(String path, Stage stage) {
        try {
            final Parent root = FXMLLoader.load(getClass().getResource(path));
            final Scene scene = new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
            stage.setTitle(TITTLE_NAME);
            stage.setScene(scene);
            stage.show();
            this.lastStage = stage;
            ListenerUtil.exitListener(stage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show(String path) {
        showWithStage(path, new Stage());
    }

    public void showAndLastClose(String path) {
        closeLastStage();
        show(path);
    }

    public void showAndLastClose(String path, Stage stage) {
        closeLastStage();
        showWithStage(path, stage);
    }

    private void closeLastStage(){
        if (lastStage != null) {
            lastStage.close();
        }
    }
}
