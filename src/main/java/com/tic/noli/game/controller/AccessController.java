package com.tic.noli.game.controller;

import com.tic.noli.game.listeners.RegisterListener;
import com.tic.noli.game.model.User;
import com.tic.noli.game.util.AlertUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
        new RegisterListener(regButton, User
                .builder()
                .name(nickName.getText())
                .email(email.getText())
                .password(password.getText())
                .role("USER")
                .build())
                .start();
    }


}
