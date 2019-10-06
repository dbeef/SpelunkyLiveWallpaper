package com.mygdx.game.level;

import com.badlogic.gdx.math.Vector2;

import java.util.Arrays;
import java.util.Random;

import static com.mygdx.game.level.Level.*;
import static com.mygdx.game.level.RoomType.*;
import static com.mygdx.game.rooms.ClosedRooms.closed_rooms;
import static com.mygdx.game.rooms.ClosedRooms.closed_rooms_loot;
import static com.mygdx.game.rooms.EntranceRooms.entrance_room;
import static com.mygdx.game.rooms.EntranceRooms.entrance_room_loot;
import static com.mygdx.game.rooms.ExitRooms.exit_room;
import static com.mygdx.game.rooms.ExitRooms.exit_room_loot;
import static com.mygdx.game.rooms.LeftRightDownRooms.left_right_down_loot;
import static com.mygdx.game.rooms.LeftRightDownRooms.left_right_down_rooms;
import static com.mygdx.game.rooms.LeftRightRooms.left_right_loot;
import static com.mygdx.game.rooms.LeftRightRooms.left_right_rooms;
import static com.mygdx.game.rooms.LeftRightUpRooms.left_right_up_loot;
import static com.mygdx.game.rooms.LeftRightUpRooms.left_right_up_rooms;

// FIXME: Does not generate proper level.
public class LevelGenerator {

    private static final int OFFSET_X = 2;
    private static final int OFFSET_Y = 2;
    private Random rand = new Random();

    private static final int CPP_RAND_MAX = 0x7fff;

    public void generateNewLevelLayout() {

        _level.clean();
        _level.write_background();
        rand = new Random();

        //set starting position to the random room in the most upper row
        int curr_x = rand.nextInt(CPP_RAND_MAX) % 3;
        int curr_y = ROOMS_Y - 1;
        //direction represents where the generator will go in the next loop iteration
        Direction direction = direction = obtain_new_direction(curr_x);

        boolean exit_placed = false;

        //set the starting room as an entrance room

        _level.layout[curr_x][curr_y] = R_ENTRANCE;

        //while we're on the very bottom floor or higher, do
        while (curr_y >= 0) {

            if (direction == Direction.LEFT || direction == Direction.RIGHT) {

                if ((direction == Direction.LEFT && curr_x == 0) || (direction == Direction.RIGHT && curr_x == 2)) {
                    //our direction is to go left, but we're already on the left side of the map, so go down
                    direction = Direction.DOWN;
                } else {

                    if (direction == Direction.LEFT)
                        //our direction is to go left, and we're not on the left side of the map yet
                        curr_x--;
                    else
                        //same, if right side
                        curr_x++;

                    if (curr_y == 0 && !exit_placed && rand.nextInt(CPP_RAND_MAX) % 2 == 0) {
                        //we're on the most bottom floor, we didn't plant an exit yet and we've guessed that's the place
                        exit_placed = true;
                        _level.layout[curr_x][curr_y] = R_EXIT;
                    } else
                        _level.layout[curr_x][curr_y] = R_LEFT_RIGHT;

                    if (rand.nextInt(CPP_RAND_MAX) % 3 == 2)
                        //random chance that we change our direction to go down in the next iteration
                        direction = Direction.DOWN;
                }

            } else if (direction == Direction.DOWN) {

                if (curr_y > 0) {

                    _level.layout[curr_x][curr_y] = R_LEFT_RIGHT_DOWN;
                    curr_y--;
                    _level.layout[curr_x][curr_y] = R_LEFT_RIGHT_UP;

                    if (curr_y == 0 && !exit_placed && rand.nextInt(CPP_RAND_MAX) % 2 == 0) {
                        //if we're on the very bottom floor, no exit planted yet and a guess tells us so, place an exit
                        exit_placed = true;
                        _level.layout[curr_x][curr_y] = R_EXIT;
                    }

                    direction = obtain_new_direction(curr_x);
                } else {
                    if (!exit_placed)
                        //we're on the very bottom floor, didn't plant an exit yet and we're
                        //done with iterating through map, so plant an exit
                        _level.layout[curr_x][curr_y] = R_EXIT;

                    break;
                }
            }
        }
    }

    public void generateFrame() {

        //upper row
        for (int a = 0; a < MAP_GAME_HEIGHT_TILES; a++) {
            _level.tiles[a][0] = MapTile.CAVE_REGULAR;
        }

        //bottom row
        for (int a = 0; a < MAP_GAME_WIDTH_TILES; a++) {
            _level.tiles[31][a] = MapTile.CAVE_REGULAR;
        }

        //right row
        for (int a = 0; a < MAP_GAME_HEIGHT_TILES; a++) {
            _level.tiles[a][31] = MapTile.CAVE_REGULAR;
        }

        //left row
        for (int a = 0; a < MAP_GAME_WIDTH_TILES; a++) {
            _level.tiles[0][a] = MapTile.CAVE_REGULAR;
        }
    }

    public void initialiseTilesFromRoomLayout() {

        //iterate through every room we have
        for (int room_y = ROOMS_Y - 1; room_y >= 0; room_y--) {
            for (int room_x = 0; room_x < ROOMS_X; room_x++) {

                //a room, 10x10 tiles
                int[][] tab = new int[10][10];
                int r;

                //basing on the room type, randomly select a variation of this room
                //and copy it to the temporary tab[10][10] array
                RoomType room_type = _level.layout[room_x][room_y];
                r = rand.nextInt(6);
                _level.layout_room_ids[room_x][room_y] = r; //-1 if completely disabling NPC's in this room

                //copying specific room variation
                switch (room_type) {
                    case R_CLOSED:
                        tab = Arrays.copyOf(closed_rooms[r], closed_rooms[r].length);
                        break;
                    case R_LEFT_RIGHT:
                        tab = Arrays.copyOf(left_right_rooms[r], left_right_rooms[r].length);
                        break;
                    case R_LEFT_RIGHT_DOWN:
                        tab = Arrays.copyOf(left_right_down_rooms[r], left_right_down_rooms[r].length);
                        break;
                    case R_LEFT_RIGHT_UP:
                        tab = Arrays.copyOf(left_right_up_rooms[r], left_right_up_rooms[r].length);
                        break;
                    case R_ENTRANCE:
                        tab = Arrays.copyOf(entrance_room[r], entrance_room[r].length);
                        break;
                    case R_EXIT:
                        tab = Arrays.copyOf(exit_room[r], exit_room[r].length);
                        break;
                    default:
                        break;
                }

                // now copy tab to 2d list of tiles
                // + 1 since there's margin of undestructable blocks on the borders of map
                int offset_x = (room_x * 10) + 1;
                int offset_y = (room_y * 10) + 1;

                for (int tile_x = 0; tile_x < 10; tile_x++)
                    for (int tile_y = 0; tile_y < 10; tile_y++) {
                        MapTile value = MapTile.values()[tab[tile_x][tile_y]];
                        if(value != MapTile.NOTHING)
                            _level.tiles[tile_x + offset_x][tile_y + offset_y] = value;
                    }
            }
        }
    }
    
    public void generateLoot() {

        int gold_bars_left = 100;
        int rubies_left = 100;
        int rocks_left = 100;
        int jars_left = 100;
        int chests_left = 100;
        int crates_left = 100;

        for (int b = ROOMS_Y - 1; b >= 0; b--) {
            for (int a = 0; a < ROOMS_X; a++) {

                int room_type = _level.layout[a][b].getValue();
                int room_id = _level.layout_room_ids[a][b];

                if (room_id == -1)
                    continue;

                for (int tab_y = 0; tab_y < ROOM_TILE_HEIGHT_GAME; tab_y++) {
                    for (int tab_x = 0; tab_x < ROOM_TILE_WIDTH_GAME; tab_x++) {

                        int npc;

                        if (room_type == RoomType.R_LEFT_RIGHT.getValue())
                            npc = left_right_loot[room_id][tab_y][tab_x];
                        else if (room_type == RoomType.R_LEFT_RIGHT_UP.getValue())
                            npc = left_right_up_loot[room_id][tab_y][tab_x];
                        else if (room_type == RoomType.R_LEFT_RIGHT_DOWN.getValue())
                            npc = left_right_down_loot[room_id][tab_y][tab_x];
                        else if (room_type == RoomType.R_ENTRANCE.getValue())
                            npc = entrance_room_loot[room_id][tab_y][tab_x];
                        else if (room_type == RoomType.R_EXIT.getValue())
                            npc = exit_room_loot[room_id][tab_y][tab_x];
                         else if (room_type == RoomType.R_CLOSED.getValue())
                            npc = closed_rooms_loot[room_id][tab_y][tab_x];
                        else
                            continue;

                        if (npc == 0)
                            continue;

                        int r = rand.nextInt(CPP_RAND_MAX) % 3;
                        int loot_type = rand.nextInt(CPP_RAND_MAX) % 6;
                        loot_type = 1;
                        r = 1;

                        int pos_y = (1 + ROOM_TILE_WIDTH_GAME * (2 - b)) + tab_x;
                        int pos_x = (1 + ROOM_TILE_HEIGHT_GAME * (2 - a)) + (10 - tab_y);

                        if (loot_type == 1 && gold_bars_left > 0 && r == 1) {

                            int goldbar_type = rand.nextInt(CPP_RAND_MAX) % 2;

                            if (goldbar_type == 0) {
                                Loot l = Loot.SINGLE_GOLD_BAR;
                                l.setPosition(new Vector2(pos_x * 16, pos_y * 16));
                                _level.loot.add(l);
                            } else {
                                Loot l = Loot.TRIPLE_GOLD_BAR;
                                l.setPosition(new Vector2(pos_x * 16, pos_y * 16));
                                _level.loot.add(l);
                            }

                            gold_bars_left--;
                        }

                        if (loot_type == 2 && rubies_left > 0 && r == 1) {

                            int ruby_type = rand.nextInt(CPP_RAND_MAX) % 2;

                            if (ruby_type == 0) {
//                                Loot l = Loot.RUBY_SMALL;
//                                l.setPosition(new Vector2(pos_x * 16, pos_y * 16));
//                                _level.loot.add(l);
                            } else {
//                                Loot l = Loot.RUBY_BIG;
//                                l.setPosition(new Vector2(pos_x * 16, pos_y * 16));
//                                _level.loot.add(l);
                            }

//                            rubies_left--;
                        }

                        if (loot_type == 3 && jars_left > 0 && r == 1) {
                            Loot l = Loot.JAR;
                            l.setPosition(new Vector2(pos_x * 16, pos_y * 16));
                            _level.loot.add(l);

                            jars_left--;
                        }

                        if (loot_type == 0 && rocks_left > 0 && r == 1) {

                            Loot l = Loot.ROCK;
                            l.setPosition(new Vector2(pos_x * 16, pos_y * 16));
                            _level.loot.add(l);

                            rocks_left--;
                        }


                        if (loot_type == 4 && chests_left > 0 && r == 1) {
                            Loot l = Loot.CHEST;
                            l.setPosition(new Vector2(pos_x * 16, pos_y * 16));
                            _level.loot.add(l);

                            chests_left--;
                        }


                        if (loot_type == 5 && crates_left > 0 && r == 1) {
//                            Crate *crate = new Crate(pos_x * 16, pos_y * 16);
//                            global::items.push_back(crate);
//                            crates_left--;
                        }
                    }
                }
            }
        }
    }

    Direction obtain_new_direction(int curr_x) {
        if (curr_x == 0)
            //we're on the left side of the map, so go right
            return Direction.RIGHT;
        else if (curr_x == 2)
            //we're on the right side of the map, so go left
            return Direction.LEFT;
        else
            //we're in the middle, so make a guess where should we gow now
            return Direction.values()[rand.nextInt(CPP_RAND_MAX) % 2];
    }

    public Level getLevel() {
        return _level;
    }

    private Level _level = new Level();
}
