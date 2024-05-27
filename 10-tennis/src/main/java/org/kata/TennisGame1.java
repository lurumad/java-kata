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
			int tempScore;

			if (player1Score == player2Score)
			{
				score = calculateEqualScore();
			}
			else if (player1Score >=4 || player2Score >=4)
			{
					int scoreDifference = player1Score - player2Score;
					if (scoreDifference==1) score ="Advantage player1";
					else if (scoreDifference ==-1) score ="Advantage player2";
					else if (scoreDifference>=2) score = "Win for player1";
					else score ="Win for player2";
			}
			else
			{
					for (int i=1; i<3; i++)
					{
							if (i==1) tempScore = player1Score;
							else { score+="-"; tempScore = player2Score;}
							switch(tempScore)
							{
									case 0:
											score+="Love";
											break;
									case 1:
											score+="Fifteen";
											break;
									case 2:
											score+="Thirty";
											break;
									case 3:
											score+="Forty";
											break;
							}
					}
			}
			return score;
	}

	private String calculateEqualScore() {
		return switch (player1Score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
	}
}