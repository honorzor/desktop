package com.tic.noli.game.controller;

import com.tic.noli.game.enums.ViewPath;
import com.tic.noli.game.listeners.ChangeStageListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewController {

    @FXML
    private Button buttonSimpleGame;

    public void initialize() {
        new ChangeStageListener(buttonSimpleGame, ViewPath.GAME_PATH).start();
    }

}
