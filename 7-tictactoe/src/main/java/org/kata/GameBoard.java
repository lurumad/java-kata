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

    private boolean checkVertical() {
        return checkCells(Cell.TopLeft, Cell.MiddleLeft, Cell.BottomLeft) ||
                checkCells(Cell.TopCenter, Cell.MiddleCenter, Cell.BottomCenter) ||
                checkCells(Cell.TopRight, Cell.MiddleRight, Cell.BottomRight);
    }

    private boolean checkDiagonal() {
        return checkCells(Cell.TopLeft, Cell.MiddleCenter, Cell.BottomRight) ||
                checkCells(Cell.TopRight, Cell.MiddleCenter, Cell.BottomLeft);
    }

    private boolean checkCells(Cell first, Cell second, Cell third) {
        return (board.containsKey(first) && board.containsKey(second) && board.containsKey(third)) &&
                (board.get(first) == board.get(second) && board.get(second) == board.get(third));
    }

    private void updateState() {
        if (checkHorizontal() || checkVertical() || checkDiagonal()) {
            state = GameState.State.Winner;
            return;
        }
        if (isFull()){
            state = GameState.State.Draw;
        }
    }

    private boolean isFull() {
        return board.size() == 9;
    }

    public GameState.State gameState() {
        return state;
    }
}
