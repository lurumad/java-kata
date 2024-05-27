package org.kata;

import java.util.Objects;

public class TennisGame1 implements TennisGame {
	public static final String PLAYER_1_NAME = "player1";
	private int player1Score = 0;
	private int player2Score = 0;

	public void wonPoint(String playerName) {
			if (Objects.equals(playerName, PLAYER_1_NAME)) {
				player1Score += 1;
			}
			else {
				player2Score += 1;
			}
	}

	public String getScore() {
			String score = "";

			if (gameIsDraw())
			{
				return calculateDrawScore();
			}

			if (gameIsWin()) {
				int scoreDifference = player1Score - player2Score;
				if (scoreDifference>=2) {
					return "Win for player1";
				}
				return "Win for player2";

			}

			if (gameIsAdvantage())
			{
                int scoreDifference = player1Score - player2Score;
				if (scoreDifference==1) {
					return "Advantage player1";
				}
				if (scoreDifference ==-1) {
					return "Advantage player2";
				}
			}

			return calculateScore(score);
	}

	private String calculateScore(String score) {
        return calculateCurrent(score, player1Score) + "-" + calculateCurrent(score, player2Score);
	}

	private static String calculateCurrent(String score, int tempScore) {
		switch(tempScore)
		{
				case 0:
						return "Love";
				case 1:
						return "Fifteen";
				case 2:
						return "Thirty";
            	case 3:
						return "Forty";
		}
		return score;
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

	private String calculateDrawScore() {
		return switch (player1Score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
	}
}