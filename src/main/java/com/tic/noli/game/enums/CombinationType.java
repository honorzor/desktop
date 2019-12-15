package com.tic.noli.game.enums;

public enum CombinationType {
    FOURTH_COMBINATION(16),
    THREE_COMBINATION(9);

    private int size;

    CombinationType(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
