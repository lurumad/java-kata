package org.kata.scores;

public abstract class Score {
    protected final int player1Score;
    protected final int player2Score;

    public Score(int player1Score, int player2Score) {
        this.player1Score = player1Score;
        this.player2Score = player2Score;
    }

    abstract String text();
}
