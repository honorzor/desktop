package com.tic.noli.game.manager;

import com.tic.noli.game.cache.StageCache;
import com.tic.noli.game.enums.ViewPath;
import com.tic.noli.game.listeners.ExitStageListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewManager {
    private static ViewManager viewManager = null;
    private final static String TITTLE_NAME = "Tic-Noil";
    private final static int DEFAULT_WIDTH = 800;
    private final static int DEFAULT_HEIGHT = 500;
    private final StageCache stageCache = new StageCache();


    private ViewManager() {
    }

    public synchronized static ViewManager getInstance() {
        if (viewManager == null) {
            viewManager = new ViewManager();
            return viewManager;
        }
        return viewManager;
    }

    private void showWithStage(ViewPath viewPath, Stage stage) {
        final Stage stageFromCache = checkInCache(viewPath);
        if (stageFromCache != null) {
            stageFromCache.show();
            return;
        }
        getNewStage(viewPath, stage).show();
    }


    private Stage getNewStage(ViewPath viewPath, Stage stage) {
        try {
            final Parent root = FXMLLoader.load(getClass().getResource(viewPath.getPath()));
            final Scene scene = new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
            stage.setTitle(TITTLE_NAME);
            stage.setScene(scene);
            stage.show();
            stageCache.put(viewPath, stage);
            new ExitStageListener(stage)
                    .start();
            return stage;
        } catch (IOException e) {
            throw new RuntimeException("global error " + e.getMessage());
        }
    }

    private void show(ViewPath path) {
        showWithStage(path, new Stage());
    }

    public void showAndLastClose(ViewPath path) {
        closeOtherStages(path);
        show(path);
    }

    public void showAndLastClose(ViewPath path, Stage stage) {
        closeOtherStages(path);
        showWithStage(path, stage);
    }

    private void closeOtherStages(ViewPath opening) {
        stageCache.closeOtherStages(opening);
    }

    private Stage checkInCache(ViewPath viewPath) {
        return stageCache.get(viewPath);
    }
}
