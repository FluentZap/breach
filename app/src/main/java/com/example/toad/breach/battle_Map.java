package com.example.toad.breach;

import android.graphics.Point;

/**
 * Created by Toad on 1/9/2017.
 */

public class battle_Map {
    public map_Tile[][] tile_map;
    public Point size;

    public battle_Map (Point _size) {
        tile_map = new map_Tile[_size.x][_size.y];
        size = _size;



    }



    public class map_Tile {
     public int id;
     public boolean blocked;

        public map_Tile (int _id, boolean _blocked) {
            id = _id;
            blocked = _blocked;
        }
    }




}
