package com.tic.noli.game.enums;

public enum MoveType {

    Tik("X"),
    Noli("0");

    private String value;

    MoveType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
