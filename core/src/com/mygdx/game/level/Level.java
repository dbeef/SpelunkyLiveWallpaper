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

    public void write_background() {
        for (int x = 0; x < TILES_X; x += 4)
            for (int y = 0; y < TILES_Y; y += 4) {

                tiles[x][y + 1] = MapTile.BGR_1;
                tiles[x + 1][y + 1] = MapTile.BGR_2;
                tiles[x + 2][y + 1] = MapTile.BGR_7;
                tiles[x + 3][y + 1] = MapTile.BGR_8;

                tiles[x][y + 0] = MapTile.BGR_3;
                tiles[x + 1][y + 0] = MapTile.BGR_4;
                tiles[x + 2][y + 0] = MapTile.BGR_5;
                tiles[x + 3][y + 0] = MapTile.BGR_6;

                tiles[x][y + 3] = MapTile.BGR_11;
                tiles[x + 1][y + 3] = MapTile.BGR_12;
                tiles[x + 2][y + 3] = MapTile.BGR_15;
                tiles[x + 3][y + 3] = MapTile.BGR_16;

                tiles[x][y + 2] = MapTile.BGR_9;
                tiles[x + 1][y + 2] = MapTile.BGR_10;
                tiles[x + 2][y + 2] = MapTile.BGR_13;
                tiles[x + 3][y + 2] = MapTile.BGR_14;
            }
    }
}
