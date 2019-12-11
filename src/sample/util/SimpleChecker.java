package sample.util;

import javafx.scene.control.TextField;
import sample.game.SimpleTikNoli;

import java.util.Arrays;
import java.util.List;

public class SimpleChecker implements Checker {

    private final List<List<TextField>> linesList;


    public SimpleChecker(List<TextField> textFields) {
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

    @Override
    public boolean checkWinner() {
        for (List<TextField> textFields : linesList) {
            if (checkLine(textFields)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkLine(List<TextField> textFields) {
        final boolean x = isX(textFields, SimpleTikNoli.TIC);
        final boolean o = isX(textFields, SimpleTikNoli.NOLI);
        return x || o;
    }

    private boolean isX(List<TextField> textFields, String tic) {
        return textFields
                .stream()
                .allMatch(textField -> textField.getText().equals(tic));
    }
}
