package com.tic.noli.game.listeners;


import com.tic.noli.game.model.User;
import com.tic.noli.game.service.UserService;
import com.tic.noli.game.util.AlertUtil;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class RegisterListener implements Listener {
    private final Node node;
    private final User user;
    private final UserService userService = new UserService();


    public RegisterListener(Node node, User user) {
        this.node = node;
        this.user = user;
    }

    @Override
    public void start() {

        node.setOnMouseClicked(event -> {
            if (user.getName().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty()) {
                AlertUtil.showAlert(Alert.AlertType.INFORMATION, "You must write all fields");
                throw new RuntimeException("");
            }
            userService.saveUser(user);
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
