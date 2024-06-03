package org.kata;

import java.util.Objects;

public class TennisGame1 implements TennisGame {
    public static final String PLAYER_1_NAME = "player1";
    private int player1Score = 0;
    private int player2Score = 0;

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, PLAYER_1_NAME)) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }
    }

    public String getScore() {
        if (gameIsDraw()) {
            return new DrawScore(player1Score, player2Score).text();
        }

        if (gameIsWin()) {
            return new WinScore(player1Score, player2Score).text();
        }

        if (gameIsAdvantage()) {
            return new AdvantageScore(player1Score, player2Score).text();
        }

        return new OnGoingScore(player1Score, player2Score).text();
    }

    private boolean gameIsWin() {
        return (player1Score >= 4 || player2Score >= 4) && Math.abs(player1Score - player2Score) >= 2;
    }

    private boolean gameIsAdvantage() {
        return player1Score >= 4 || player2Score >= 4 && Math.abs(player1Score - player2Score) == 1;
    }

    private boolean gameIsDraw() {
        return player1Score == player2Score;
    }

}