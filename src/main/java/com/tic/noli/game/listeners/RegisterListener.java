package com.tic.noli.game.listeners;


import com.tic.noli.game.model.User;
import com.tic.noli.game.service.UserService;
import com.tic.noli.game.util.AlertUtil;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.xml.soap.Text;

public class RegisterListener implements Listener {
    private final Node node;
    private final TextField nickName;
    private final TextField password;
    private final TextField email;
    private final UserService userService = new UserService();


    public RegisterListener(Node node, TextField nickName, TextField password, TextField email) {
        this.node = node;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
    }


    @Override
    public void start() {

        node.setOnMouseClicked(event -> {
            if (nickName.getText().isEmpty() || password.getText().isEmpty() || email.getText().isEmpty()) {
                AlertUtil.showAlert(Alert.AlertType.INFORMATION, "You must write all fields");
                throw new RuntimeException("");
            }
            userService.saveUser(User
                    .builder()
                    .name(nickName.getText())
                    .password(password.getText())
                    .email(email.getText())
                    .role("USER")
                    .build());
        });
    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isEnable() {
        return false;
    }
}
