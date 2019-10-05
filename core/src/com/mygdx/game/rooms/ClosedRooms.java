package com.mygdx.game.rooms;

public class ClosedRooms {

    public static final int[][][] closed_rooms = {
        {
            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
            {0, 0, 0, 0,  0, 0, 0,  9, 0, 0},
            {2, 0, 8, 8, 8, 8,  8, 10, 0,  2},
            {1, 0, 0, 0, 0, 0,  0, 9, 0, 3},
            {1, 0, 0, 8, 8, 8, 0, 9, 0, 0},
            {3, 0, 0, 0, 0, 0, 0, 9, 0, 2},
            {0, 0, 0, 0, 0, 0, 0,  9, 2, 1},
            {0, 0, 0,  0, 0, 0, 0, 2, 7, 1},
            {7, 7, 7, 7, 7, 7, 7, 7, 7, 6},
            {2, 2, 2, 2, 2, 2, 2, 2, 2, 6},
        },
        {
            {1, 3, 3, 3, 3, 3, 2, 2, 3, 1},
            {1, 0, 0, 0,  0, 0, 2,  2, 0, 7},
            {8, 0, 0, 0, 0, 0,  7, 6,  0,  6},
            {1, 8, 8, 0, 0, 0,  2, 7, 0, 1},
            {1, 0, 0, 0, 0, 0, 3, 6, 6, 1},
            {3, 0, 0, 0, 0, 0, 0, 3, 3, 3},
            {0, 0, 0, 0, 0, 0, 0,  0, 0, 0},
            {0, 0, 0,  0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 5, 7, 5, 7, 0, 0, 7},
            {7, 7, 7, 7, 2, 2, 2, 7, 7, 6},
        },
        {
            {1, 3, 3, 3, 3, 2, 2, 2, 2, 1},
            {1, 0, 0, 0,  0, 3, 6,  2, 3, 7},
            {8, 0, 0, 0, 0, 0,  3, 2,  0,  6},
            {1, 0, 0, 0, 0, 0,  0, 3, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 8},
            {3, 0, 0, 0, 0, 0, 0, 0, 0, 3},
            {0, 0, 0, 0, 0, 0, 12, 0, 0, 0},
            {0, 0, 7,  7, 7, 0, 5, 0, 0, 2},
            {0, 7, 2, 2, 2, 7, 2, 0, 7, 6},
            {7, 2, 2, 2, 2, 2, 2, 7, 2, 6},
        },
        {

            {0, 0, 0, 9, 2, 2, 0, 0, 0, 1},
            {2, 2, 2, 10, 3, 3, 12, 0, 9, 1},
            {1, 2, 2, 9, 0, 11, 2, 2,  10, 1},
            {1, 6, 2, 9, 2, 4,  2, 8, 9, 1},
            {7, 2, 2, 9, 3, 5, 2, 2, 9, 1},
            {1, 2, 3, 0, 0, 0, 6, 2, 9, 8},
            {1, 7, 0, 2, 2, 0, 0,  0, 9, 1},
            {1, 2, 0,  3, 3, 0, 2, 2, 9, 2},
            {3, 3, 0, 0, 0, 0, 2, 2, 5, 3},
            {0, 0, 0, 0, 0, 0, 3, 3, 0, 0},
        },
        {

            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0,  0, 0, 8,  8, 0, 0},
            {8, 0, 0, 0, 8, 9,  0, 5,  0,  0},
            {0, 0, 0, 0, 0, 10, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 9, 2, 2, 0, 0},
            {0, 2, 8, 2, 0, 9, 7, 2, 0, 0},
            {0, 3, 0, 3, 0, 9, 2,  7, 0, 0},
            {0, 0, 0,  0, 0, 0, 2, 2, 8, 2},
            {0, 0, 0, 0, 0, 0, 2, 2, 0, 3},
            {7, 7, 7, 7, 7, 7, 2, 2, 2, 2},
        },
        {

            {3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
            {0, 0, 0, 0,  0, 0, 0,  0, 0, 0},
            {2, 2, 0, 0, 0, 0,  0, 0,  2,  2},
            {7, 6, 5, 0, 2, 0,  2, 0, 8, 1},
            {1, 2, 4, 5, 3, 2, 3, 8, 2, 7},
            {3, 3, 0, 4, 0, 3, 0, 0, 2, 3},
            {0, 0, 0, 0, 0, 0, 0,  0, 8, 0},
            {0, 0, 11, 5, 0, 0, 0, 0, 3, 8},
            {0, 0, 2, 2, 7, 7, 7, 0, 0, 0},
            {7, 7, 2, 2, 2, 2, 2, 7, 7, 2},
        }
    };

//1 snake
//2 bat
//3 spider
//4 spikes
//5 caveman
//6 damsel
//7 lamp
//8 shopkeeper [TODO Enum for NPCType]
//9 arrow trap left oriented (12 tile type)
//10 arrow trap right oriented (13 tile type)

    public static final int[][][] closed_rooms_npcs = {
        {
            {0, 0, 0,  0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 5, 1, 1,  0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0,  0, 0, 0},
            {0, 0, 0, 1, 13, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0,  0, 0, 0},
            {1, 1,  1, 5, 13, 1, 1, 0, 0, 0},
            {0, 0, 0,  0, 0,  0, 0, 0, 0, 0},
            {0, 0, 0, 0,  0, 0, 0, 0, 0, 0},
        },
        {
            {0, 0, 0,  0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0,  0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0,  0, 0, 0},
            {0, 0, 0, 0, 0,  0, 0, 0, 0, 0},
            {0, 3, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0,  0, 0, 0},
            {0, 0,  0, 1, 5,  1, 0, 0, 0, 0},
            {5, 1, 13, 0, 0,  0, 0, 1, 1, 0},
            {0, 0, 0, 0,  0, 0, 0, 0, 0, 0},
        },
        {
            {0, 0, 0,  0, 0, 0, 0, 0, 0, 0},
            {0, 2, 3, 2, 3, 0, 0,  0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0,  0, 0, 0},
            {0, 0, 0, 0, 0,  0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 5, 1, 0, 10, 0, 0, 0},
            {0, 13, 0, 0, 0,  0, 0, 0, 0, 0},
            {1, 0, 0,  0, 0,  0, 0, 0, 0, 0},
            {0, 0, 0, 0,  0, 0, 0, 0, 0, 0},
        },
        {
            {1, 1, 13, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 10, 1, 0, 0},
            {0, 0, 0, 0, 0, 9, 0,  0, 0, 0},
            {0, 0, 0, 0, 0,  0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 5, 4, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0,  0, 0, 0},
            {0, 0,  0, 0, 0,  0, 0, 0, 0, 0},
            {0, 0, 0,  2, 3,  0, 0, 0, 0, 0},
            {1, 1, 1, 13, 1, 1, 0, 0, 1, 1},
        },
        {
            {0, 0, 0,  0, 0, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0,  0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0,  0, 0, 0},
            {0, 0, 0, 0, 0,  0, 0, 0, 0, 0},
            {0, 1, 1, 5, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3, 0, 0, 0, 0,  0, 1, 1},
            {0, 2,  0, 2, 0,  0, 0, 0, 0, 0},
            {1, 1, 1,  1, 13, 4, 0, 0, 1, 0},
            {0, 0, 0, 0,  0, 0, 0, 0, 0, 0},},
        {

            {0, 0, 0,  0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 0,  0, 1, 1},
            {0, 0, 1, 0, 1, 0, 13, 0, 0, 0},
            {0, 0, 0, 5, 0,  1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 2, 0, 3, 0, 2, 3, 0, 0},
            {2, 3, 0, 0, 0, 0, 0,  0, 0, 0},
            {0, 0,  9, 0, 0,  0, 0, 0, 0, 0},
            {1, 4, 0,  0, 0,  0, 0, 0, 0, 0},
            {0, 0, 0, 0,  0, 0, 0, 0, 0, 0},
        }
    };

    public static final int[][][] closed_rooms_loot = {
        {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 13, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0,  0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 13, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        },
        {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0,  0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0,  0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 13, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0, 0, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        },
        {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0,  0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 13, 1, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0,  0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        },
        {

            {1, 1, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0,  0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0,  0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0,  0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 0, 0, 1, 1},
        },
        {

            {0, 0, 0, 0, 0, 0, 1, 6, 0, 0},
            {1, 0, 0, 0, 0,  0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0,  0, 0, 0, 0, 1, 6},
            {0, 0, 0, 0, 0,  0, 0, 0, 0, 0},
            {1, 1, 1, 6, 1, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        },
        {

            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0,  0, 0, 0, 1, 6},
            {0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0,  0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0,  0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        }
    };
}
