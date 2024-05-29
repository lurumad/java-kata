package org.kata;

import org.kata.combinations.Single;

import java.util.HashMap;

public class CombinationFactory {
    private final HashMap<Category, Combination> combinations = new HashMap<>(){
        {
            put(Category.Ones, new Single(Dice.One));
            put(Category.Twos, new Single(Dice.Two));
            put(Category.Threes, new Single(Dice.Three));
            put(Category.Fours, new Single(Dice.Four));
            put(Category.Fives, new Single(Dice.Five));
            put(Category.Sixes, new Single(Dice.Six));
        }
    };

    public Combination combinationFor(Category category) {
        return combinations.get(category);
    }
}
