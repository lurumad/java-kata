package org.kata.combinations;

import org.kata.Combination;
import org.kata.Dice;
import org.kata.Roll;

public class Ones implements Combination {
    public int score(Roll roll) {
        return roll.sum(Dice.One);
    }
}
