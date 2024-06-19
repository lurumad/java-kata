package org.kata;

public class Tile
{
    private final Coordinates coordinates;
    private Player player;

    public Tile(Coordinates coordinates) {
        this.coordinates = coordinates;
        this.player = Player.NONE;
    }

    public boolean sameCoordinates(Tile tile) {
        return this.coordinates.equals(tile.coordinates);
    }

    public boolean isEmpty() {
        return this.player == Player.NONE;
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public boolean isSameSymbol(Tile tile) {
        return this.player == tile.player;
    }

    public void setSymbol(Player player) {
        this.player = player;
    }

    public char getSymbol() {
        return toChar(this.player);
    }

    public static char toChar(Player player) {
        if (player == Player.X) {
            return 'X';
        }
        if (player == Player.O) {
            return 'O';
        }
        return ' ';
    }
}