package org.kata.combinations;

import org.kata.Combination;
import org.kata.Dice;
import org.kata.Roll;

public class Single implements Combination {
    private final Dice dice;

    public Single(Dice dice) {
        this.dice = dice;
    }

    public int score(Roll roll) {
        return roll.sum(dice);
    }
}
