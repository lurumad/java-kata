package org.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicTacToeTest {
    @Test
    public void x_always_plays_first() {
        var game = new TicTacToe();
        var state = game.state();
        assertThat(state.player()).isEqualTo(Player.X);
    }
}
