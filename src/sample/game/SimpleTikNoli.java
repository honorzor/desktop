package sample.game;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import sample.enums.TickOrNoli;
import sample.util.AlertUtil;
import sample.util.SimpleChecker;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class SimpleTikNoli implements TikNoli {
    public final static String TIC = "X";
    public final static String NOLI = "0";

    private final static String emptyCell = "";
    private final static String victoryMessage = "Победа!";
    private final static String drawMessage = "Ничья, ходов не осталось!";

    private static TickOrNoli lastStep = TickOrNoli.Tik;
    private final List<TextField> allFields;
    private final TextField winnersTable;
    private final TextField resetStat;
    private final SimpleChecker simpleChecker;
    private static int countTick = 0;
    private static int countNoil = 0;
    private static final String statMsg = "Tick(X) won %s times , Noil(0) won %s times";


    public void soundEffect(){
        String ssound = "src/effect.mp3";
        Media sound = new Media(new File(ssound).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.stop();
        mediaPlayer.play();
    }


    private void clearCell (){
        for (TextField textField : allFields){
            textField.setStyle("-fx-background-color: white");
        }
    }


    @Override
    public void resetStat() {
        countTick = 0;
        countNoil = 0;
        appendToWinnersTable(format(statMsg, countNoil, countNoil));
    }

    private void tableStat() {
        switchValue();

        if (lastStep.getValue().equals(SimpleTikNoli.TIC)) {
            countTick++;
        }
        if (lastStep.getValue().equals(SimpleTikNoli.NOLI)) {
            countNoil++;
        }
        appendToWinnersTable(format(statMsg, countTick, countNoil));
    }

    private void showLastStep() {
        System.out.println(lastStep.getValue());
    }

    private void appendToWinnersTable(String msg) {
        this.winnersTable.clear();
        this.winnersTable.setText(msg);
    }

    public SimpleTikNoli(List<TextField> allFields, TextField winnersTable, TextField resetStat) {
        this.allFields = allFields;
        this.winnersTable = winnersTable;
        this.resetStat = resetStat;
        this.simpleChecker = new SimpleChecker(allFields);
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
                textField.setStyle("-fx-background-color: gray");
                if (!textField.getText().isEmpty()) {
                    return;
                }
                textField.setText(lastStep.getValue());
                showLastStep();
                switchValue();

                if (allFieldsIsNotEmpty()) {
                    clear();
                    clearCell();
                }
                if (simpleChecker.checkWinner()) {
                    clear();
                    AlertUtil.showAlert(Alert.AlertType.INFORMATION, victoryMessage);
                    tableStat();
                    clearCell();

                }
                if (!hasAction()) {
                    clear();
                    AlertUtil.showAlert(Alert.AlertType.INFORMATION, drawMessage);
                    tableStat();
                    clearCell();
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
        soundEffect();
        if (allFields.size() >= 5) {
            final List<TextField> emptyCell = allFields
                    .stream()
                    .filter(text -> text.getText().isEmpty())
                    .collect(Collectors.toList());

            for (TextField textField : emptyCell) {
                textField.setText(TIC);
            }
            boolean tickCheck = simpleChecker.checkWinner();
            for (TextField textField : emptyCell) {
                textField.setText(NOLI);
            }
            boolean noliChek = simpleChecker.checkWinner();

            for (TextField textField : emptyCell) {
                textField.setText(SimpleTikNoli.emptyCell);
            }
            return tickCheck && noliChek;
        }
        return false;
    }
}
