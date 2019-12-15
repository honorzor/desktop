package com.tic.noli.game.enums;

public enum ViewPath {

    VIEW_PATH("/fxml/view.fxml"),
    GAME_PATH("/fxml/game.fxml"),
    GAME_PATHFOUR("/fxml/gamefour.fxml");

    private final String path;

    ViewPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
