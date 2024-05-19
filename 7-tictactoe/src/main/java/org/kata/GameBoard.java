package org.kata;

import java.util.HashMap;
import java.util.Map;

public class GameBoard {
    private final Map<Cell, Player> board;
    private GameState.State state;

    private GameBoard() {
        board = new HashMap<>();
        state = GameState.State.OnGoing;
    }

    public static GameBoard init() {
        return new GameBoard();
    }

    public void placeMarker(Cell cell, Player player) {
        if (board.containsKey(cell)) {
            throw TicTacToeException.playersCannotPlayOnAPlayedSquare();
        }
        board.put(cell, player);
        updateState();
    }

    private boolean checkHorizontal() {
        return checkCells(Cell.TopLeft, Cell.TopCenter, Cell.TopRight) ||
                checkCells(Cell.MiddleLeft, Cell.MiddleCenter, Cell.MiddleRight) ||
                checkCells(Cell.BottomLeft, Cell.BottomCenter, Cell.BottomRight);
    }

    private boolean checkCells(Cell left, Cell center, Cell right) {
        return (board.containsKey(left) && board.containsKey(center) && board.containsKey(right)) &&
                (board.get(left) == board.get(center) && board.get(center) == board.get(right));
    }

    public void updateState() {
        if (checkHorizontal()) {
            state = GameState.State.Winner;
        }
    }

    public GameState.State gameState() {
        return state;
    }
}
