package com.tic.noli.game.controller;

import com.tic.noli.game.enums.ViewPath;
import com.tic.noli.game.listeners.ChangeStageListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewController {

    @FXML
    private Button buttonSimpleGame;
    @FXML
    private Button buttonFourGame;
    @FXML
    private Button registration;

    public void initialize() {
        new ChangeStageListener(buttonSimpleGame, ViewPath.GAME_PATH).start();
        new ChangeStageListener(buttonFourGame,ViewPath.GAME_PATHFOUR).start();
        new ChangeStageListener(registration,ViewPath.REGISTRATION_PATH).start();
    }

}
