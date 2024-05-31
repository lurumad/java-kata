package org.kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class YahtzeeTest {
    @ParameterizedTest
    @MethodSource("singleCombinations")
    public void the_player_scores_the_sum_of_the_dice_that_reads_one_two_three_four_five_or_six_respectively(
            Roll roll, Category category, int scoreExpected
    ) {
        var game = Yahtzee.start();
        var score = game.place(roll, category);
        assertThat(score).isEqualTo(scoreExpected);
    }

    @Test
    public void player_cannot_assign_to_already_assigned_category() {
        var game = Yahtzee.start();
        var roll = new Roll(Dice.Two, Dice.Two, Dice.Three, Dice.Five, Dice.Six);
        var score = game.place(roll, Category.Twos);
        var exception = assertThrows(YahtzeeException.class, () -> game.place(roll, Category.Twos));
        assertEquals(exception.getMessage(), YahtzeeException.playerCannotAssignToAlreadyAssignedCategory);
    }

    @Test
    public void the_player_scores_the_sum_of_the_two_highest_matching_dice() {
        var game = Yahtzee.start();
        var roll = new Roll(Dice.Two, Dice.Two, Dice.Three, Dice.Three, Dice.Six);
        var score = game.place(roll, Category.Pair);
        assertThat(score).isEqualTo(6);
    }

    private static Stream<Arguments> singleCombinations() {
        return Stream.of(
                Arguments.of(
                        new Roll(Dice.One, Dice.One, Dice.Three, Dice.Five, Dice.Six),
                        Category.Ones,
                        2
                ),
                Arguments.of(
                        new Roll(Dice.Two, Dice.Two, Dice.Three, Dice.Five, Dice.Six),
                        Category.Twos,
                        4
                ),
                Arguments.of(
                        new Roll(Dice.Two, Dice.Three, Dice.Three, Dice.Five, Dice.Six),
                        Category.Threes,
                        6
                ),
                Arguments.of(
                        new Roll(Dice.Two, Dice.Four, Dice.Four, Dice.One, Dice.Six),
                        Category.Fours,
                        8
                ),
                Arguments.of(
                        new Roll(Dice.Two, Dice.Four, Dice.One, Dice.Five, Dice.Five),
                        Category.Fives,
                        10
                ),
                Arguments.of(
                        new Roll(Dice.Two, Dice.Four, Dice.One, Dice.Six, Dice.Six),
                        Category.Sixes,
                        12
                )
        );
    }
}
