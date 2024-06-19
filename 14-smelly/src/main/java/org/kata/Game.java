package org.kata;

// Large class
public class Game {
    private Player _lastSymbol = Player.NONE;
    private final Board _board = new Board();

    public void Play(Coordinates coordinates, Player player) throws Exception {
        validateFirstMove(player);
        validateAlternatePlayer(player);
        validatePosition(coordinates);
        updateGameState(coordinates, player);
    }

    private void validateFirstMove(Player player) throws Exception {
        if (_lastSymbol == Player.NONE) {
            if (player == Player.O) {
                throw new Exception("Invalid first player");
            }
        }
    }

    private void validateAlternatePlayer(Player player) throws Exception {
        if (player == _lastSymbol) {
            throw new Exception("Invalid next player");
        }
    }

    private void validatePosition(Coordinates coordinates) throws Exception {
        if (_board.TileAt(coordinates).isNotEmpty()) {
            throw new Exception("Invalid position");
        }
    }

    private void updateGameState(Coordinates coordinates, Player player) {
        _lastSymbol = player;
        _board.AddTileAt(coordinates, player);
    }

    public char Winner() {
        for (int row = 0; row < 3; row++) {
            Character winner = _board.winnerOnRow(row);
            if (winner != null) {
                return winner;
            }
        }

        return Tile.toChar(Player.NONE);
    }

}
