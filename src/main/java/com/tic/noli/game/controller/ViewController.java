package com.tic.noli.game.controller;

import com.tic.noli.game.enums.ViewPath;
import com.tic.noli.game.listeners.ActionListener;
import com.tic.noli.game.listeners.ChangeStageListener;
import com.tic.noli.game.listeners.ExitStageListener;
import com.tic.noli.game.util.AlertUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class ViewController {

    @FXML
    private Button buttonSimpleGame;
    @FXML
    private Button buttonFourGame;
    @FXML
    private Button registration;
    @FXML
    private MenuItem author;

    public void initialize() {
        new ChangeStageListener(buttonSimpleGame, ViewPath.GAME_PATH).start();
        new ChangeStageListener(buttonFourGame, ViewPath.GAME_PATHFOUR).start();
        new ChangeStageListener(registration, ViewPath.REGISTRATION_PATH).start();
        new ActionListener(author).start();
    }

}
