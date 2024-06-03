package org.kata;

public class WinScore extends Score {

    public WinScore(int player1Score, int player2Score) {
        super(player1Score, player2Score);
    }

    @Override
    String text() {
        int scoreDifference = player1Score - player2Score;
        if (scoreDifference >= 2) {
            return "Win for player1";
        }
        return "Win for player2";
    }
}
