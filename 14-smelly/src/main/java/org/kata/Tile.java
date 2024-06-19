package org.kata;

// Data class
// Primitive Obsession
// Inappropriate Intimacy
// Data clumps (X, Y)
public class Tile
{
    private final int x;
    private final int y;
    private char symbol;

    public Tile() {
        x = 0;
        y = 0;
        symbol = ' ';
    }

    public Tile(int x, int y, char symbol) {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.symbol = ' ';
    }

    public boolean sameCoordinates(Tile tile) {
        return this.x == tile.x && this.y == tile.y;
    }

    public boolean isEmpty() {
        return this.symbol == ' ';
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public boolean isSameSymbol(Tile tile) {
        return this.symbol == tile.symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }
}