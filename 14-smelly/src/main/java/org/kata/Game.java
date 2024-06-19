package org.kata;

// Large class
public class Game {
    public static final char EMPTY = ' ';
    public static final char PLAYER_O = 'O';
    private char _lastSymbol = EMPTY;
    private final Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        validateFirstMove(symbol);
        validateAlternatePlayer(symbol);
        validatePosition(x, y);
        updateGameState(symbol, x, y);
    }

    private void validateFirstMove(char symbol) throws Exception {
        if (_lastSymbol == EMPTY) {
            if (symbol == PLAYER_O) {
                throw new Exception("Invalid first player");
            }
        }
    }

    private void validateAlternatePlayer(char symbol) throws Exception {
        if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
    }

    private void validatePosition(int x, int y) throws Exception {
        if (_board.TileAt(x, y).isNotEmpty()) {
            throw new Exception("Invalid position");
        }
    }

    private void updateGameState(char symbol, int x, int y) {
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    public char Winner() {
        for (int row = 0; row < 3; row++) {
            Character winner = _board.winnerOnRow(row);
            if (winner != null) {
                return winner;
            }
        }

        return EMPTY;
    }

}
