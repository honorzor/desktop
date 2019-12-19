package com.tic.noli.game;

import com.tic.noli.game.config.DBInit;
import com.tic.noli.game.enums.ViewPath;
import com.tic.noli.game.managaer.ViewManager;
import com.tic.noli.game.model.User;
import com.tic.noli.game.service.UserService;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewManager.getInstance()
                .showAndLastClose(ViewPath.VIEW_PATH, primaryStage);
    }

    public static void main(String[] args) {
        DBInit.init();
        launch(args);
    }
}
