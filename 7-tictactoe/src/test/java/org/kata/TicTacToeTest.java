package org.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeTest {
    @Test
    public void x_always_plays_first() {
        var game = new TicTacToe();
        var state = game.state();
        assertThat(state.player()).isEqualTo(Player.X);
    }

    @Test
    public void switch_turns() {
        var game = new TicTacToe();
        game.placeMarker(Cell.MiddleCenter);
        var state = game.state();
        assertThat(state.player()).isEqualTo(Player.O);
    }

    @Test
    public void players_cannot_play_on_a_played_square() {
        var game = new TicTacToe();
        game.placeMarker(Cell.MiddleCenter);
        var exception = assertThrows(TicTacToeException.class, () -> game.placeMarker(Cell.MiddleCenter));
        assertEquals(exception.getMessage(), TicTacToeException.PlayersCannotPlayOnAPlayedSquare);
    }
}
