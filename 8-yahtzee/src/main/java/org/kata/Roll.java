package org.kata;

import java.util.Iterator;

public class Roll {
    private final Dice [] dices;

    public Roll(Dice first, Dice second, Dice third, Dice fourth, Dice fifth) {
        this.dices = new Dice[] {first, second, third, fourth, fifth};
    }

    public int sum(Dice dice) {
        int sum = 0;
        for (Dice d : dices) {
            if (d == dice) {
                sum += dice.value();
            }
        }
        return sum;
    }
}
