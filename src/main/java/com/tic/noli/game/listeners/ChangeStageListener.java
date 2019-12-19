package com.tic.noli.game.listeners;

import com.tic.noli.game.enums.ViewPath;
import com.tic.noli.game.managaer.ViewManager;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class ChangeStageListener implements Listener {

    private boolean isEnable = true;
    private final Node node;
    private final ViewPath viewPath;

    public ChangeStageListener(Node node, ViewPath viewPath) {
        this.node = node;
        this.viewPath = viewPath;
    }

    @Override
    public void start() {
        node.setOnMouseClicked(event -> {
            if (isEnable) {
                ViewManager
                        .getInstance()
                        .showAndLastClose(this.viewPath);
            }
        });
    }

    @Override
    public void stop() {
        isEnable = false;
    }

    @Override
    public boolean isEnable() {
        return isEnable;
    }
}
