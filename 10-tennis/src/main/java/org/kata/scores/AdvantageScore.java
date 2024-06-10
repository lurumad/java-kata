package org.kata.scores;

public class AdvantageScore extends Score {
    public AdvantageScore(int player1Score, int player2Score) {
        super(player1Score, player2Score);
    }

    @Override
    public String text() {
        int scoreDifference = player1Score - player2Score;
        if (scoreDifference == 1) {
            return "Advantage player1";
        }
        if (scoreDifference == -1) {
            return "Advantage player2";
        }
        return null;
    }
}
