package org.kata;

// Data class
// Primitive Obsession
// Inappropriate Intimacy
// Data clumps (X, Y)
public class Tile
{
    public int X;
    public int Y;
    public char Symbol;

    public Tile() {
        X = 0;
        Y = 0;
        Symbol = ' ';
    }

    public Tile(int x, int y, char symbol) {
        this.X = x;
        this.Y = y;
        this.Symbol = symbol;
    }

    public boolean sameCoordinates(Tile tile) {
        return this.X == tile.X && this.Y == tile.Y;
    }
}