package org.kata;

import java.util.Arrays;

public class Roll {
    private final Dice [] dices;

    public Roll(Dice first, Dice second, Dice third, Dice fourth, Dice fifth) {
        this.dices = new Dice[] {first, second, third, fourth, fifth};
    }

    public int sum(Dice dice) {
        return Arrays.stream(dices)
                .filter(d -> d == dice)
                .mapToInt(d -> dice.value())
                .sum();
    }
}
