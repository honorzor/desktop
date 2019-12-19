package com.tic.noli.game.model;

import com.tic.noli.game.enums.CombinationType;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.List;

public class SimpleCombination implements CombinationList{

    private final static int CELLS_SIZE = CombinationType.THREE_COMBINATION.getSize();

    private final List<List<TextField>> combinations;


    public SimpleCombination(List<TextField> textFields){
        checkSize(textFields);

         this.combinations = Arrays.asList(
                Arrays.asList(textFields.get(0), textFields.get(1), textFields.get(2)),
                Arrays.asList(textFields.get(3), textFields.get(4), textFields.get(5)),
                Arrays.asList(textFields.get(6), textFields.get(7), textFields.get(8)),
                Arrays.asList(textFields.get(0), textFields.get(3), textFields.get(6)),
                Arrays.asList(textFields.get(1), textFields.get(4), textFields.get(7)),
                Arrays.asList(textFields.get(2), textFields.get(5), textFields.get(8)),
                Arrays.asList(textFields.get(0), textFields.get(4), textFields.get(8)),
                Arrays.asList(textFields.get(2), textFields.get(4), textFields.get(6)));
    }

    @Override
    public CombinationType getCombinationType() {
        return CombinationType.THREE_COMBINATION;
    }

    private void checkSize(List<TextField> textFields) {
        if (textFields.size() != CELLS_SIZE) {
            throw new RuntimeException("for this game cells size must be " + CELLS_SIZE);
        }
    }

    @Override
    public List<List<TextField>> getCombinationsList() {
        return combinations;
    }
}
