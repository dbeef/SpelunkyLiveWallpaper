package com.mygdx.game.level;

public class Level {

    public static final int TILES_X = 32;
    public static final int TILES_Y = 32;

    public static final int ROOMS_X = 3;
    public static final int ROOMS_Y = 3;

    public static final int ROOM_TILE_WIDTH_GAME = 10;
    public static final int ROOM_TILE_HEIGHT_GAME = 10;

    public static final int MAP_GAME_HEIGHT_TILES = 32;
    public static final int MAP_GAME_WIDTH_TILES = 32;

    public MapTile[][] tiles = new MapTile[TILES_X][TILES_Y];
    // Holds information on what room type is at specific array index
    public RoomType[][] layout = new RoomType[ROOMS_X][ROOMS_Y];
    // Holds information on specific variation of room type, that is given from 'layout' array
    // i.e, we have 6 possible 'closed' rooms declared in the closed_rooms.hpp,
    // so this array lets us know, that we have a 'closed' room number 3 (for example) at some place.
    public int[][] layout_room_ids = new int[ROOMS_X][ROOMS_Y];

    public void clean() {
        for (int x = 0; x < TILES_X; x++)
            for (int y = 0; y < TILES_Y; y++)
                tiles[x][y] = MapTile.NOTHING;

        for (int x = 0; x < ROOMS_X; x++)
            for (int y = 0; y < ROOMS_Y; y++)
                layout[x][y] = RoomType.R_CLOSED;
    }
}
