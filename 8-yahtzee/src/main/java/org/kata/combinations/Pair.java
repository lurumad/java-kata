package org.kata.combinations;

import org.kata.Combination;
import org.kata.Roll;

public class Pair implements Combination {
    @Override
    public int score(Roll roll) {
        return roll.sumMaxPair();
    }
}
