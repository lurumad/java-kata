package org.kata;

public class TicTacToe {
    private Player currentPlayer;
    private final GameBoard board;

    public TicTacToe() {
        this.currentPlayer = Player.X;
        this.board = GameBoard.init();
    }

    public GameState state() {
        return new GameState(currentPlayer);
    }

    public void placeMarker(Cell cell) {
        board.placeMarker(cell, currentPlayer);
        switchTurn();
    }

    private void switchTurn() {
        if (currentPlayer == Player.X) {
            currentPlayer = Player.O;
            return;
        }
        currentPlayer = Player.X;
    }
}