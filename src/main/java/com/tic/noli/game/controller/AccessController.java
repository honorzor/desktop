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
    private Button registration2;


    public void initialize() {
        new RegisterListener(registration2, getUser(
                nickName.getText(),
                password.getText(),
                email.getText(),
                "USER")).
                start();
    }

    public User getUser(String name, String password, String email, String role) {
        if (name.isEmpty() || password.isEmpty() || email.isEmpty() || role.isEmpty()) {
            AlertUtil.showAlert(Alert.AlertType.INFORMATION, "You must write all fields");
            throw new RuntimeException("");
        }
        User user = User
                .builder()
                .name(name)
                .password(password)
                .email(email)
                .role(role)
                .build();
        return user;
    }

}
