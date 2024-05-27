package org.kata.combinations;

import org.kata.Combination;
import org.kata.Dice;
import org.kata.Roll;

public class Twos implements Combination {
    public int score(Roll roll) {
        return roll.sum(Dice.Two);
    }
}
