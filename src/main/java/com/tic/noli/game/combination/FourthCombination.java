package com.tic.noli.game.combination;

import com.tic.noli.game.enums.CombinationType;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;

public class FourthCombination implements CombinationList {
    private final List<List<TextField>> combinations;

    private final static int CELLS_SIZE = CombinationType.FOURTH_COMBINATION.getSize();


    public FourthCombination(List<TextField> textFields) {
        checkSize(textFields);

        this.combinations = Arrays.asList(
                Arrays.asList(textFields.get(0), textFields.get(1), textFields.get(2), textFields.get(3)),
                Arrays.asList(textFields.get(4), textFields.get(5), textFields.get(6), textFields.get(7)),
                Arrays.asList(textFields.get(8), textFields.get(9), textFields.get(10), textFields.get(11)),
                Arrays.asList(textFields.get(12), textFields.get(13), textFields.get(14), textFields.get(15)),
                Arrays.asList(textFields.get(0), textFields.get(5), textFields.get(10), textFields.get(15)),
                Arrays.asList(textFields.get(12), textFields.get(9), textFields.get(6), textFields.get(3)),
                Arrays.asList(textFields.get(0), textFields.get(4), textFields.get(8), textFields.get(12)),
                Arrays.asList(textFields.get(1), textFields.get(5), textFields.get(9), textFields.get(13)),
                Arrays.asList(textFields.get(2), textFields.get(6), textFields.get(10), textFields.get(14)),
                Arrays.asList(textFields.get(3), textFields.get(7), textFields.get(11), textFields.get(15)));
    }


    private void checkSize(List<TextField> textFields) {
        if (textFields.size() != CELLS_SIZE) {
            throw new RuntimeException("for this game cells size must be " + CELLS_SIZE);
        }
    }


    @Override
    public CombinationType getCombinationType() {
        return CombinationType.FOURTH_COMBINATION;
    }

    @Override
    public List<List<TextField>> getCombinationsList() {
        return combinations;
    }
}
