package com.tic.noli.game.game;

import com.tic.noli.game.enums.MoveType;
import com.tic.noli.game.util.AlertUtil;
import com.tic.noli.game.service.Checker;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.media.AudioClip;


import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class SimpleTikNoli implements TikNoli {

    private final static MoveType TIC = MoveType.Tik;
    private final static MoveType NOLI = MoveType.Noli;
    private final static String EMPTY_CELL = "";
    private final static String VICTORY_MSG = "Победа!";
    private final static String PATH_TO_SOUND = "file:src/main/resources/sound/eff.mp3";
    private final static String DRAW_MSG = "Ничья, ходов не осталось!";
    private final static String STAT_MSG = "Tick(X) won %s times , Noil(0) won %s times";
    private final static String GREY_BACKGROUND = "-fx-background-color: gray";
    private final static int MAX_FIELDS = 9;
    private final static AudioClip audioClip = new AudioClip(PATH_TO_SOUND);

    private final List<TextField> allFields;
    private final TextField winnersTable;
    private final TextField resetStat;
    private final Checker checker;
    private int countTick = 0;
    private int countNoil = 0;

    private MoveType lastStep = MoveType.Tik;


    public SimpleTikNoli(List<TextField> allFields, TextField winnersTable, TextField resetStat, Checker checker) {
        this.allFields = allFields;
        this.winnersTable = winnersTable;
        this.resetStat = resetStat;
        this.checker = checker;
    }


    private void soundEffect() {
        audioClip.play();
    }

    private void clearCell() {
        allFields.forEach(field -> field.setStyle("-fx-background-color: white"));
    }


    @Override
    public void resetStat() {
        countTick = 0;
        countNoil = 0;
        appendToWinnersTable(format(STAT_MSG, countNoil, countNoil));
    }

    private void tableStat() {
        switchValue();

        if (lastStep.equals(SimpleTikNoli.TIC)) {
            countTick++;
        }
        if (lastStep.equals(SimpleTikNoli.NOLI)) {
            countNoil++;
        }
        appendToWinnersTable(format(STAT_MSG, countTick, countNoil));
    }

    private void appendToWinnersTable(String msg) {
        this.winnersTable.clear();
        this.winnersTable.setText(msg);
    }


    @Override
    public void start() {
        addAllListeners();
        appendToWinnersTable(STAT_MSG);
    }

    @Override
    public void clear() {
        allFields.forEach(text -> text.setText(EMPTY_CELL));
    }

    private void switchValue() {
        lastStep = lastStep == MoveType.Tik ? MoveType.Noli : MoveType.Tik;
    }

    private void addAllListeners() {
        for (TextField textField : allFields) {
            textField.setOnMouseClicked(event -> {

                if (!textField.getText().isEmpty()) {
                    if (!checker.checkWinner()) {
                        return;
                    }
                    AlertUtil.showAlert(Alert.AlertType.INFORMATION, VICTORY_MSG);
                    tableStat();
                    clearCell();
                    switchValue();
                }

                textField.setStyle(GREY_BACKGROUND);
                soundEffect();
                textField.setText(lastStep.getValue());

                switchValue();
                if (checker.checkWinner()) {
                    clear();
                    AlertUtil.showAlert(Alert.AlertType.INFORMATION, VICTORY_MSG);
                    tableStat();
                    clearCell();
                    switchValue();
                }
                if (!hasAction()) {
                    clear();
                    AlertUtil.showAlert(Alert.AlertType.INFORMATION, DRAW_MSG);
                    tableStat();
                    clearCell();
                }

                if (allFieldsIsNotEmpty()) {
                    clear();
                    clearCell();
                }
            });
        }
    }

    private boolean allFieldsIsNotEmpty() {
        return allFields
                .stream()
                .filter(text -> !text.getText().isEmpty())
                .count() == MAX_FIELDS;
    }


    private boolean hasAction() {
        if (allFields.size() >= 5) {
            final List<TextField> emptyCells = getEmptyTextFields();

            emptyCells.forEach(emptyCell -> emptyCell.setText(TIC.getValue()));

            boolean tickCheck = checker.checkWinner();

            emptyCells.forEach(emptyCell -> emptyCell.setText(NOLI.getValue()));

            boolean noliCheck = checker.checkWinner();

            emptyCells.forEach(emptyCell -> emptyCell.setText(EMPTY_CELL));

            return tickCheck && noliCheck;
        }
        return false;
    }

    private List<TextField> getEmptyTextFields() {
        return allFields
                .stream()
                .filter(text -> text.getText().isEmpty())
                .collect(Collectors.toList());
    }
}
