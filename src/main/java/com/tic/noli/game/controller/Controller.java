package com.tic.noli.game.controller;

import com.tic.noli.game.game.SimpleTikNoli;
import com.tic.noli.game.game.TikNoli;
import com.tic.noli.game.util.Checker;
import com.tic.noli.game.util.SimpleChecker;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;

public class Controller {
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
    private TextField resetStat;

    private TikNoli tikNoli;

    public void initialize() {
        final List<TextField> allFields = Arrays.asList(textField1, textField2, textField3,
                textField4, textField5, textField6,
                textField7, textField8, textField9);

        final Checker checker = new SimpleChecker(allFields);
        this.tikNoli = new SimpleTikNoli(allFields, winnersTable, resetStat, checker);
        this.tikNoli.start();
    }

    public void setResetStat() {
        tikNoli.resetStat();
    }
}
