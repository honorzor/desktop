package com.tic.noli.game.managaer;

import com.tic.noli.game.enums.ViewPath;
import com.tic.noli.game.util.ListenerUtil;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ViewManager {
    private static ViewManager viewManager = null;
    private final static String TITTLE_NAME = "Tic-Noil";
    private final static int DEFAULT_WIDTH = 800;
    private final static int DEFAULT_HEIGHT = 400;
    private final static Map<ViewPath, Stage> lastStages = new LinkedHashMap<>();

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
        try {
            final Parent root = FXMLLoader.load(getClass().getResource(viewPath.getPath()));
            final Scene scene = new Scene(root, DEFAULT_WIDTH, DEFAULT_HEIGHT);
            stage.setTitle(TITTLE_NAME);
            stage.setScene(scene);
            stage.show();
            lastStages.put(viewPath, stage);
            ListenerUtil.exitListener(stage);
        } catch (IOException e) {
            e.printStackTrace();
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
        lastStages
                .entrySet()
                .stream()
                .filter(viewPathStageEntry -> viewPathStageEntry.getKey() != opening)
                .forEach(viewPathStageEntry -> viewPathStageEntry.getValue().close());
    }

    private Stage checkInCache(ViewPath viewPath) {
        return lastStages.get(viewPath);
    }
}
