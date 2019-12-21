package com.tic.noli.game.controller;

import com.tic.noli.game.listeners.RegisterListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class AccessController {

    @FXML
    private TextField nickName;
    @FXML
    private TextField password;
    @FXML
    private TextField email;
    @FXML
    private Button regButton;


    public void initialize() {
        new RegisterListener(regButton, nickName, password, email)
                .start();
    }

}
