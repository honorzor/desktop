package com.tic.noli.game.controller;

import com.tic.noli.game.enums.ViewPath;
import com.tic.noli.game.game.SimpleTikNoli;
import com.tic.noli.game.game.TikNoli;
import com.tic.noli.game.listeners.ChangeStageListener;
import com.tic.noli.game.service.Checker;
import com.tic.noli.game.service.CheckerService;
import com.tic.noli.game.combination.SimpleCombination;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;

public class GameSimpleController {
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
    private TextField winnersTable;

    @FXML
    private Button resetStat;

    @FXML
    private Button back;

    private TikNoli tikNoli;

    public void initialize() {
        final List<TextField> allFields = Arrays.asList(textField1, textField2, textField3,
                textField4, textField5, textField6,
                textField7, textField8, textField9);

        final Checker checker = new CheckerService(new SimpleCombination(allFields));
        backListener();
        this.tikNoli = new SimpleTikNoli(allFields, winnersTable, resetStat, checker);
        this.tikNoli.start();
    }

    public void setResetStat() {
        tikNoli.resetStat();
    }

    private void backListener(){
       new ChangeStageListener(back, ViewPath.VIEW_PATH)
               .start();
    }
}
