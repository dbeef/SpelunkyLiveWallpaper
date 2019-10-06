package com.mygdx.game.level;

// Taken from SpelunkyDS's tiles/MapTile.hpp

public enum MapTile {
    NOTHING(0),
    CAVE_ROCK(1),
    CAVE_REGULAR(2),
    STONE_BLOCK(3),
    CAVE_DOWN_ORIENTED(4),
    CAVE_SOME_GOLD(5),
    CAVE_MUCH_GOLD(6),
    CAVE_UP_ORIENTED(7),
    CAVE_UP_DOWN_ORIENTED(8),
    LADDER(9),
    LADDER_DECK(10),
    ARROW_TRAP_LEFT(11),
    ARROW_TRAP_RIGHT(12),
    ENTRANCE(13),
    EXIT(14),
    CONSOLE_LEFT_BAR_TOP_ROUNDED(15),
    CONSOLE_RIGHT_BAR_TOP_ROUNDED(16),
    CONSOLE_LEFT_BAR_BOT_ROUNDED(17),
    CONSOLE_RIGHT_BAR_BOT_ROUNDED(18),
    CONSOLE_TOP_BAR(19),
    CONSOLE_BOTTOM_BAR(20),
    CONSOLE_LEFT_BAR(21),
    CONSOLE_RIGHT_BAR(22),
    CONSOLE_BLACK_BACKGROUND(23),
    CAVE_SMOOTH(24),
    SCORES_STAR_DOOR(25),
    SCORES_SUN_DOOR(26),
    SCORES_MOON_DOOR(27),
    SCORES_CHANGING_DOOR(28),
    SHOP_SIGN_RARE(29),
    SHOP_SIGN_WEAPON(30),
    SHOP_SIGN_BOMBS(31),
    SHOP_SIGN_CLOTHING(32),
    SHOP_SIGN_CRAPS(33),
    SHOP_SIGN_GENERAL(34),
    SHOP_SIGN_KISSING(35),
    NA(36),
    SHOP_MUGSHOT_1(37),
    SHOP_MUGSHOT_2(38),
    SHOP_MUGSHOT_3(39),
    SHOP_MUGSHOT_4(40),
    ALTAR_LEFT(41),
    ALTAR_RIGHT(42),
    BGR_1(43),
    BGR_2(44),
    BGR_3(45),
    BGR_4(46),
    BGR_5(47),
    BGR_6(48),
    BGR_7(49),
    BGR_8(50),
    BGR_9(51),
    BGR_10(52),
    BGR_11(53),
    BGR_12(54),
    BGR_13(55),
    BGR_14(56),
    BGR_15(57),
    BGR_16(58),
    _END(59);

    MapTile(int value) {
        _value = value;
    }

    public int getValue() {
        return _value;
    }

    private int _value;
};
