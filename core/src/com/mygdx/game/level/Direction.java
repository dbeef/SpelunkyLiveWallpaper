package com.mygdx.game.level;

public enum Direction {
    LEFT(0),
    RIGHT(1),
    DOWN(2);

    Direction(int value) {
        _value = value;
    }

    private int _value;

    public int getValue() {
        return _value;
    }
}
