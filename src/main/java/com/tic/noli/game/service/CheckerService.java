package com.tic.noli.game.service;

import com.tic.noli.game.combination.CombinationList;
import com.tic.noli.game.enums.MoveType;
import javafx.scene.control.TextField;

import java.util.List;

public class CheckerService implements Checker {

    private final CombinationList combinationList;

    public CheckerService(CombinationList combinationList) {
        this.combinationList = combinationList;
    }

    @Override
    public boolean checkWinner() {
        for (List<TextField> textFields : combinationList.getCombinationsList()) {
            if (checkLine(textFields)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkLine(List<TextField> textFields) {
        final boolean x = isX(textFields, MoveType.Tik);
        final boolean o = isX(textFields, MoveType.Noli);
        return x || o;
    }

    private boolean isX(List<TextField> textFields, MoveType moveType) {
        return textFields
                .stream()
                .allMatch(textField -> textField.getText().equals(moveType.getValue()));
    }
}
