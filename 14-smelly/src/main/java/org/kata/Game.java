package org.kata;

// Large class
public class Game {
    public static final char EMPTY = ' ';
    public static final char PLAYER_O = 'O';
    private char _lastSymbol = EMPTY;
    private Board _board = new Board();

    public void Play(char symbol, int x, int y) throws Exception {
        validateFirstMove(symbol);
        validateAlternatePlayer(symbol);
        validatePosition(x, y);
        updateGameState(symbol, x, y);
    }

    private void updateGameState(char symbol, int x, int y) {
        _lastSymbol = symbol;
        _board.AddTileAt(symbol, x, y);
    }

    private void validatePosition(int x, int y) throws Exception {
        if (_board.TileAt(x, y).Symbol != EMPTY) {
            throw new Exception("Invalid position");
        }
    }

    private void validateAlternatePlayer(char symbol) throws Exception {
        if (symbol == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
    }

    private void validateFirstMove(char symbol) throws Exception {
        if (_lastSymbol == EMPTY) {
            if (symbol == PLAYER_O) {
                throw new Exception("Invalid first player");
            }
        }
    }

    // Long method
    // Primitive obsession
    public char Winner() {
        var winnerFirstRow = winnerOnRow(0);
        if (winnerFirstRow != null) return winnerFirstRow;

        Character winnerSecondRow = winnerOnRow(1);
        if (winnerSecondRow != null) return winnerSecondRow;

        Character winnerThirdRow = winnerOnRow(2);
        if (winnerThirdRow != null) return winnerThirdRow;

        return EMPTY;
    }

    private Character winnerOnRow(int x) {
        // Feature envy
        if (_board.TileAt(x, 0).Symbol != EMPTY &&
                _board.TileAt(x, 1).Symbol != EMPTY &&
                _board.TileAt(x, 2).Symbol != EMPTY) {
            //if first row is full with same symbol
            if (_board.TileAt(x, 0).Symbol ==
                    _board.TileAt(x, 1).Symbol &&
                    _board.TileAt(x, 2).Symbol == _board.TileAt(x, 1).Symbol) {
                return _board.TileAt(x, 0).Symbol;
            }
        }
        return null;
    }
}
