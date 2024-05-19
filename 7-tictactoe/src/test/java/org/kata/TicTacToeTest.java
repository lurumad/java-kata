package org.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicTacToeTest {
    @Test
    public void x_always_plays_first() {
        var game = new TicTacToe();
        var state = game.state();
        assertThat(state).isEqualTo(GameState.onGoing(Player.X));
    }

    @Test
    public void switch_turns() {
        var game = new TicTacToe();
        game.placeMarker(Cell.MiddleCenter);
        var state = game.state();
        assertThat(state).isEqualTo(GameState.onGoing(Player.O));
    }

    @Test
    public void players_cannot_play_on_a_played_square() {
        var game = new TicTacToe();
        game.placeMarker(Cell.MiddleCenter);
        var exception = assertThrows(TicTacToeException.class, () -> game.placeMarker(Cell.MiddleCenter));
        assertEquals(exception.getMessage(), TicTacToeException.PlayersCannotPlayOnAPlayedSquare);
    }

    @ParameterizedTest
    @MethodSource("horizontalMovements")
    public void a_player_wins_when_it_has_three_squares_in_a_row_horizontally(List<Cell> cells) {
        var game = new TicTacToe();
        cells.forEach(game::placeMarker);
        var state = game.state();
        assertThat(state).isEqualTo(GameState.winner(Player.X));
    }

    private static Stream<Arguments> horizontalMovements() {
        return Stream.of(
                Arguments.of(
                        List.of(
                                Cell.TopLeft,
                                Cell.MiddleLeft,
                                Cell.TopCenter,
                                Cell.MiddleCenter,
                                Cell.TopRight
                        )
                ),
                Arguments.of(
                        List.of(
                                Cell.MiddleLeft,
                                Cell.BottomLeft,
                                Cell.MiddleCenter,
                                Cell.BottomCenter,
                                Cell.MiddleRight
                        )
                ),
                Arguments.of(
                        List.of(
                                Cell.BottomLeft,
                                Cell.MiddleLeft,
                                Cell.BottomCenter,
                                Cell.MiddleCenter,
                                Cell.BottomRight
                        )
                )
        );
    }
}
