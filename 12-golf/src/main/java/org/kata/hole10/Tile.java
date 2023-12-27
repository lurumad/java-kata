package org.kata.hole10;

public class Tile
{
    private Position position;
    private char player;

    public Tile(int x, int y, char player) {
        this.position = new Position(x,y);
        this.player = player;
    }

    public Tile(int x, int y) {
        this(x,y,' ');
    }

    public boolean isNotEmpty() { return this.getPlayer() != ' ';}

    public boolean hasSameSymbolAs(Tile other) { return this.getPlayer() == other.getPlayer();}

    public boolean hasSamePositionAs(Tile other) {return this.position.equals(other.position);}

    public char getPlayer() {
        return player;
    }

    public void setPlayer(char player) {
        this.player = player;
    }
}