package com.mygdx.game.level;

import com.badlogic.gdx.math.Vector2;

public enum Loot {
    JAR(0),
    SINGLE_GOLD_BAR(1),
    TRIPLE_GOLD_BAR(2),
    ROCK(3),
    CHEST(4),
    _END(5);

    Loot(int value) { this._value = value; }
    public void setPosition(Vector2 position) { this._position = position;}
    public Vector2 getPosition() { return _position;}
    public int getValue() { return _value; }
    private int _value = 0;
    private Vector2 _position = new Vector2(0,0);
}
