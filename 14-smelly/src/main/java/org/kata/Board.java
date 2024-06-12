package org.kata;

import java.util.ArrayList;
import java.util.List;

public class Board
{
    private List<Tile> _plays = new ArrayList<>();

    public Board()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                // Inappropriate Intimacy
                Tile tile = new Tile();
                tile.X = i;
                tile.Y = j;
                tile.Symbol = ' ';
                _plays.add(tile);
            }
        }
    }

    // Primitive Obsession
    // Data clumps (x, y)
    public Tile TileAt(int x, int y)
    {
        for (Tile t : _plays) {
            // Feature Envy
            // Inappropriate Intimacy
            if (t.X == x && t.Y == y){
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
}