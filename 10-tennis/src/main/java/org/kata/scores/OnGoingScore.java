package org.kata.scores;

public class OnGoingScore extends Score {
    public OnGoingScore(int player1Score, int player2Score) {
        super(player1Score, player2Score);
    }

    @Override
    public String text() {
        return onGoing(player1Score) + "-" + onGoing(player2Score);
    }

    private String onGoing(int playerScore) {
        return switch (playerScore) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };
    }

}
