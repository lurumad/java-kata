package org.kata;

public class DrawScore extends Score {

    public DrawScore(int player1Score, int player2Score) {
        super(player1Score, player2Score);
    }

    @Override
    String text() {
        return switch (player1Score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}
