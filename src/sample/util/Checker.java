package sample.util;

import javafx.scene.control.TextField;
import sample.game.SimpleTikNoli;

import java.util.Arrays;
import java.util.List;

public class Checker {

    private final List<List<TextField>> linesList;


    public Checker(List<TextField> textFields) {

        this.linesList = Arrays.asList(
                Arrays.asList(textFields.get(0), textFields.get(1), textFields.get(2)),
                Arrays.asList(textFields.get(3), textFields.get(4), textFields.get(5)),
                Arrays.asList(textFields.get(6), textFields.get(7), textFields.get(8)),
                Arrays.asList(textFields.get(0), textFields.get(3), textFields.get(6)),
                Arrays.asList(textFields.get(1), textFields.get(4), textFields.get(7)),
                Arrays.asList(textFields.get(2), textFields.get(5), textFields.get(8)),
                Arrays.asList(textFields.get(0), textFields.get(4), textFields.get(8)),
                Arrays.asList(textFields.get(2), textFields.get(4), textFields.get(6)));
    }

    public boolean checkWinner() {
        for (List<TextField> textFields : linesList) {
            if (checkLine(textFields)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkLine(List<TextField> textFields) {
        final boolean x = textFields
                .stream()
                .allMatch(textField -> textField.getText().equals(SimpleTikNoli.TIC));
        final boolean o = textFields
                .stream()
                .allMatch(textField -> textField.getText().equals(SimpleTikNoli.NOLI));
        return x || o;
    }
}
