package com.tic.noli.game.listeners;

import com.tic.noli.game.util.AlertUtil;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;


public class ActionListener implements Listener {


    private final MenuItem menuItem;

    private boolean isEnable = true;


    public ActionListener(MenuItem menuItem) {
        this.menuItem = menuItem;
    }


    @Override
    public void start() {
        menuItem.setOnAction(event -> {
            if (isEnable) {
                AlertUtil.showAlert(Alert.AlertType.INFORMATION, "SMN & HNR");
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
