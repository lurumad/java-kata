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
                _plays.add(new Tile(x, y));
            }
        }
    }

    // Primitive Obsession
    // Data clumps (x, y)
    public Tile TileAt(int x, int y)
    {
        for (Tile t : _plays) {
            if (t.sameCoordinates(new Tile(x, y))) {
                return t;
            }
        }
        return null;
    }

    // Primitive Obsession
    // Data clumps (symbol, x, y)
    public void AddTileAt(char symbol, int x, int y)
    {
        TileAt(x,y).Symbol = symbol;
    }

    public Character winnerOnRow(int x) {
        if (TileAt(x, 0).isNotEmpty() &&
                TileAt(x, 1).isNotEmpty() &&
                TileAt(x, 2).isNotEmpty()) {
            if (TileAt(x, 0).Symbol ==
                    TileAt(x, 1).Symbol &&
                    TileAt(x, 2).Symbol == TileAt(x, 1).Symbol) {
                return TileAt(x, 0).Symbol;
            }
        }
        return null;
    }
}