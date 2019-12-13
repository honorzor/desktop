package com.tic.noli.game.controller;

import com.tic.noli.game.enums.ViewPath;
import com.tic.noli.game.managaer.ViewManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ViewController {

    @FXML
    private Button buttonSimpleGame;

    public void initialize() {
        buttonSimpleGame.setOnMouseClicked(event -> ViewManager
                .getInstance()
                .showAndLastClose(ViewPath.GAME_PATH.getPath(), new Stage()));
    }

}
