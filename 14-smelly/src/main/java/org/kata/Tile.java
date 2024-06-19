package org.kata;

// Data class
// Primitive Obsession
// Inappropriate Intimacy
// Data clumps (X, Y)
public class Tile
{
    private final int x;
    private final int y;
    public char Symbol;

    public Tile() {
        x = 0;
        y = 0;
        Symbol = ' ';
    }

    public Tile(int x, int y, char symbol) {
        this.x = x;
        this.y = y;
        this.Symbol = symbol;
    }

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.Symbol = ' ';
    }

    public boolean sameCoordinates(Tile tile) {
        return this.x == tile.x && this.y == tile.y;
    }

    public boolean isEmpty() {
        return this.Symbol == ' ';
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public boolean isSameSymbol(Tile tile) {
        return this.Symbol == tile.Symbol;
    }
}