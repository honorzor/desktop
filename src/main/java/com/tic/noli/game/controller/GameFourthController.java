package com.tic.noli.game.controller;

import com.tic.noli.game.enums.ViewPath;
import com.tic.noli.game.game.FourTikNoil;
import com.tic.noli.game.game.TikNoli;
import com.tic.noli.game.listeners.ChangeStageListener;
import com.tic.noli.game.service.Checker;
import com.tic.noli.game.combination.FourthCombination;
import com.tic.noli.game.service.CheckerService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;

public class GameFourthController {
    @FXML
    public TextField textField1;
    @FXML
    public TextField textField2;
    @FXML
    public TextField textField3;
    @FXML
    public TextField textField4;
    @FXML
    public TextField textField5;
    @FXML
    public TextField textField6;
    @FXML
    public TextField textField7;
    @FXML
    public TextField textField8;
    @FXML
    public TextField textField9;
    @FXML
    public TextField textField10;
    @FXML
    public TextField textField11;
    @FXML
    public TextField textField12;
    @FXML
    public TextField textField13;
    @FXML
    public TextField textField14;
    @FXML
    public TextField textField15;
    @FXML
    public TextField textField16;

    @FXML
    private Button back;

    @FXML
    private TextField winnersTable;

    @FXML
    private Button resetStat;
    @FXML
    private Button startNewGame;

    private TikNoli tikNoli;

    public void initialize() {
        final List<TextField> allFields = Arrays.asList(
                textField1, textField2, textField3,
                textField4, textField5, textField6,
                textField7, textField8, textField9,
                textField10, textField11, textField12,
                textField13, textField14, textField15, textField16);

        final Checker checker = new CheckerService(new FourthCombination(allFields));
        backListener();
        this.tikNoli = new FourTikNoil(allFields, winnersTable, resetStat, startNewGame, checker);
        this.tikNoli.start();
    }

    public void startNewGame() {
        tikNoli.clear();
        tikNoli.start();
    }

    public void setResetStat() {
        tikNoli.resetStat();
    }

    private void backListener() {
        new ChangeStageListener(back, ViewPath.VIEW_PATH)
                .start();
    }


}
