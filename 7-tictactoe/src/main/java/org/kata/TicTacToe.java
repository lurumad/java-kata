package org.kata;

import static org.kata.GameState.State.OnGoing;

public class TicTacToe {
    private Player currentPlayer;
    private final GameBoard board;

    public TicTacToe() {
        this.currentPlayer = Player.X;
        this.board = GameBoard.init();
    }

    public GameState state() {
        return GameState.from(currentPlayer, board.gameState());
    }

    public void placeMarker(Cell cell) {
        board.placeMarker(cell, currentPlayer);
        if (board.gameState() == OnGoing) {
            switchTurn();
        }
    }

    private void switchTurn() {
        if (currentPlayer == Player.X) {
            currentPlayer = Player.O;
            return;
        }
        currentPlayer = Player.X;
    }
}