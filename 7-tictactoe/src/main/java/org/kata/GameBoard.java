package org.kata;

import java.util.HashMap;
import java.util.Map;

public class GameBoard {
    private final Map<Cell, Player> board;

    private GameBoard() {
        board = new HashMap<>();
    }

    public static GameBoard init() {
        return new GameBoard();
    }

    public void placeMarker(Cell cell, Player player) {
        if (board.containsKey(cell)) {
            throw TicTacToeException.playersCannotPlayOnAPlayedSquare();
        }
        board.put(cell, player);
    }
}
