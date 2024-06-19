package org.kata;

import java.util.ArrayList;
import java.util.List;

public class Board
{
    private List<Tile> _plays = new ArrayList<>();

    public Board()
    {
        for (int x = 0; x < 3; x++)
        {
            for (int y = 0; y < 3; y++)
            {
                _plays.add(new Tile(new Coordinates(x, y)));
            }
        }
    }

    // Primitive Obsession
    // Data clumps (x, y)
    public Tile TileAt(int x, int y)
    {
        for (Tile t : _plays) {
            if (t.sameCoordinates(new Tile(new Coordinates(x, y)))) {
                return t;
            }
        }
        return null;
    }

    // Primitive Obsession
    // Data clumps (symbol, x, y)
    public void AddTileAt(char symbol, int x, int y)
    {
        TileAt(x,y).setSymbol(symbol);
    }

    public Character winnerOnRow(int x) {
        if (TileAt(x, 0).isNotEmpty() &&
                TileAt(x, 1).isNotEmpty() &&
                TileAt(x, 2).isNotEmpty()) {
            if (TileAt(x, 0).isSameSymbol(TileAt(x, 1)) &&
                    TileAt(x, 2).isSameSymbol(TileAt(x, 1))) {
                return TileAt(x, 0).getSymbol();
            }
        }
        return null;
    }
}