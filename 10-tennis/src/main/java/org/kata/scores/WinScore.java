package org.kata.scores;

public class WinScore extends Score {

    public WinScore(int player1Score, int player2Score) {
        super(player1Score, player2Score);
    }

    @Override
    public String text() {
        int scoreDifference = player1Score - player2Score;
        if (scoreDifference >= 2) {
            return "Win for player1";
        }
        return "Win for player2";
    }
}
