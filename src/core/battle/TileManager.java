package core.battle;

import java.util.ArrayList;

public class TileManager {
    public ArrayList<Tile> sideATiles;
    public ArrayList<Tile> sideBTiles;

    public TileManager(ArrayList<Tile> sideATiles, ArrayList<Tile> sideBTiles) {
        this.sideATiles = sideATiles;
        this.sideBTiles = sideBTiles;
    }
}
