package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.game.SimpleTikNoli;
import sample.game.TikNoli;

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

    private List<TextField> allFields;

    private TikNoli tikNoli;

    public void initialize() {
        allFields = Arrays.asList(textField1, textField2, textField3,
                textField4, textField5, textField6,
                textField7, textField8, textField9);
        this.tikNoli = new SimpleTikNoli(allFields, winnersTable);
        this.tikNoli.start();
    }
}
