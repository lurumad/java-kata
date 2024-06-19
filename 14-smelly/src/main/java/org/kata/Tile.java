package org.kata;

public class Tile
{
    private final Coordinates coordinates;
    private char symbol;

    public Tile(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.symbol = ' ';
    }

    public boolean sameCoordinates(Tile tile) {
        return this.coordinates.equals(tile.coordinates);
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