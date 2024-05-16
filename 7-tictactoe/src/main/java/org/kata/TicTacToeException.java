package org.kata;

public class TicTacToeException extends RuntimeException {
    public static final String PlayersCannotPlayOnAPlayedSquare = "Players cannot play on a played square";

    private TicTacToeException(String message) {
        super(message);
    }

    public static TicTacToeException playersCannotPlayOnAPlayedSquare() {
        return new TicTacToeException(PlayersCannotPlayOnAPlayedSquare);
    }
}
