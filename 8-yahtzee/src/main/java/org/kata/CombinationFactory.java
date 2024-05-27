package org.kata;

import org.kata.combinations.*;

import java.util.HashMap;

public class Context {
    private final HashMap<Categories, Combination> combinations = new HashMap<>(){
        {
            put(Categories.Ones, new Ones());
            put(Categories.Twos, new Twos());
            put(Categories.Threes, new Threes());
            put(Categories.Fours, new Fours());
            put(Categories.Fives, new Fives());
            put(Categories.Sixes, new Sixes());
            put(Categories.Pair, new Pair());
        }
    };

    public Combination combinationBy(Categories category) {
        return combinations.get(category);
    }
}
