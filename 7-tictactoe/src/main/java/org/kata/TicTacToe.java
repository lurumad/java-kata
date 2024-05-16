package org.kata;

public class TicTacToe {
    private Player currentPlayer;

    public TicTacToe(){
        this.currentPlayer = Player.X;
    }

    public GameState state() {
        return new GameState(currentPlayer);
    }

    public void place() {
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