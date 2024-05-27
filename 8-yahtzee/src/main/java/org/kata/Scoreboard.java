package org.kata;

import java.util.HashMap;

public class Combinations {
    private final HashMap<Category, Integer> categoryScores = new HashMap<>();

    public void assign(int score, Category category) {
        if (categoryScores.containsKey(category)) {
            throw YahtzeeException.playerCannotAssignToAlreadyAssignedCategory();
        }
        categoryScores.put(category, score);
    }
}
