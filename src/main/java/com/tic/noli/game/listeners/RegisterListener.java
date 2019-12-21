package com.tic.noli.game.listeners;


import com.tic.noli.game.model.User;
import com.tic.noli.game.service.UserService;
import com.tic.noli.game.util.AlertUtil;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class RegisterListener implements Listener {

    private final Node node;
    private final TextField nickName;
    private final TextField password;
    private final TextField email;
    private final UserService userService = new UserService();

    private boolean isEnable = true;


    public RegisterListener(Node node, TextField nickName, TextField password, TextField email) {
        this.node = node;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
    }


    @Override
    public void start() {
        node.setOnMouseClicked(event -> {
            if (isEnable) {
                if (nickName.getText().isEmpty() || password.getText().isEmpty() || email.getText().isEmpty()) {
                    AlertUtil.showAlert(Alert.AlertType.INFORMATION, "You must write all fields");
                    throw new RuntimeException("");
                }
                try {
                    final User user = User.builder()
                            .name(nickName.getText())
                            .password(password.getText())
                            .email(email.getText())
                            .role("USER")
                            .build();

                    userService.saveUser(user);

                    AlertUtil.showAlert(Alert.AlertType.INFORMATION, "Success registration, your name is: " + user.getName());
                } catch (SQLException e) {
                    AlertUtil.showAlert(Alert.AlertType.WARNING, e.getMessage());
                }

            }
        });
    }

    @Override
    public void stop() {
        isEnable = false;
    }

    @Override
    public boolean isEnable() {
        return false;
    }
}
