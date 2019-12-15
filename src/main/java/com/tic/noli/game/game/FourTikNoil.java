package com.tic.noli.game.game;

import com.tic.noli.game.service.Checker;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



import java.util.List;

public class FourTikNoil extends SimpleTikNoli {

    private final static int MAX_FIELDS = 16;

    public FourTikNoil(List<TextField> allFields, TextField winnersTable, Button resetStat, Checker checker) {
        super(allFields, winnersTable, resetStat, checker);
    }


    @Override
    protected boolean allFieldsIsNotEmpty() {
        return getAllFields()
                .stream()
                .filter(text -> !text.getText().isEmpty())
                .count() == MAX_FIELDS;
    }

    @Override
    protected boolean hasAction() {
        if (getAllFields().size() >= 9) {
            final List<TextField> emptyCells = getEmptyTextFields();

            emptyCells.forEach(emptyCell -> emptyCell.setText(TIC.getValue()));

            boolean tickCheck = getChecker().checkWinner();

            emptyCells.forEach(emptyCell -> emptyCell.setText(NOLI.getValue()));

            boolean noliCheck = getChecker().checkWinner();

            emptyCells.forEach(emptyCell -> emptyCell.setText(EMPTY_CELL));

            return tickCheck && noliCheck;
        }
        return false;
    }

}
