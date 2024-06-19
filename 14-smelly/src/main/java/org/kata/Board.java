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

    public Tile TileAt(Coordinates coordinates)
    {
        for (Tile t : _plays) {
            if (t.sameCoordinates(new Tile(coordinates))) {
                return t;
            }
        }
        return null;
    }

    public void AddTileAt(Coordinates coordinates, Player player)
    {
        TileAt(coordinates).setSymbol(player);
    }

    public Character winnerOnRow(int x) {
        if (TileAt(new Coordinates(x, 0)).isNotEmpty() &&
                TileAt(new Coordinates(x, 1)).isNotEmpty() &&
                TileAt(new Coordinates(x, 2)).isNotEmpty()) {
            if (TileAt(new Coordinates(x, 0)).isSameSymbol(TileAt(new Coordinates(x, 1))) &&
                    TileAt(new Coordinates(x, 2)).isSameSymbol(TileAt(new Coordinates(x, 1)))) {
                return TileAt(new Coordinates(x, 0)).getSymbol();
            }
        }
        return null;
    }
}