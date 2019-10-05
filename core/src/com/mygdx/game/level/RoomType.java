package com.mygdx.game.level;

public enum RoomType {
    R_CLOSED(0),
    R_LEFT_RIGHT(1),
    R_LEFT_RIGHT_DOWN(2),
    R_LEFT_RIGHT_UP(3),
    R_EXIT(4),
    R_ENTRANCE(5),
    R_SHOP_LEFT(6),
    R_SHOP_RIGHT(7),
    R_SHOP_LEFT_MUGSHOT(8),
    R_SHOP_RIGHT_MUGSHOT(9),
    R_ALTAR(10);

    RoomType(int value) {
        _value = value;
    }

    private int _value;

    public int getValue() {
        return _value;
    }
}