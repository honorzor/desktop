package sample.game;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import sample.enums.TickOrNoli;
import sample.util.AlertUtil;
import sample.util.Checker;

import java.util.List;
import java.util.stream.Collectors;

public class SimpleTikNoli implements TikNoli {
    public final static String TIC = "X";
    public final static String NOLI = "0";

    private final static String emptyCell = "";
    private final static String victoryMessage = "Победа!";
    private final static String drawMessage = "Ничья, ходов не осталось!";
    private static TickOrNoli lastStep = TickOrNoli.Tik;
    private final List<TextField> allFields;
    private final Checker checker;


    public SimpleTikNoli(List<TextField> allFields) {
        this.allFields = allFields;
        this.checker = new Checker(allFields);
    }

    @Override
    public void start() {
        addAllListeners();
    }

    @Override
    public void clear() {
        allFields.forEach(text -> text.setText(emptyCell));
    }

    private static void switchValue() {
        lastStep = lastStep == TickOrNoli.Tik ? TickOrNoli.Noli : TickOrNoli.Tik;
    }

    private void addAllListeners() {
        for (TextField textField : allFields) {
            textField.setOnMouseClicked(event -> {
                if (!textField.getText().isEmpty()) {
                    return;
                }
                textField.setText(lastStep.getValue());
                switchValue();
                if (allFieldsIsNotEmpty()) {
                    clear();
                }
                if (checker.checkWinner()) {
                    clear();
                    AlertUtil.showAlert(Alert.AlertType.INFORMATION, victoryMessage);
                }
                if (!hasAction()) {
                    AlertUtil.showAlert(Alert.AlertType.INFORMATION, drawMessage);
                    clear();
                }
            });
        }
    }

    private boolean allFieldsIsNotEmpty() {
        return allFields
                .stream()
                .filter(text -> !text.getText().isEmpty())
                .collect(Collectors.toList()).size() == 9;
    }


    private boolean hasAction() {
        if (allFields.size() >= 5) {
            final List<TextField> emptyCell = allFields
                    .stream()
                    .filter(text -> text.getText().isEmpty())
                    .collect(Collectors.toList());

            for (TextField textField : emptyCell) {
                textField.setText(TIC);
            }
            boolean tickCheck = checker.checkWinner();
            for (TextField textField : emptyCell) {
                textField.setText(NOLI);
            }
            boolean noliChek = checker.checkWinner();

            for (TextField textField : emptyCell) {
                textField.setText(SimpleTikNoli.emptyCell);
            }
            return tickCheck && noliChek;
        }
        return false;
    }
}
