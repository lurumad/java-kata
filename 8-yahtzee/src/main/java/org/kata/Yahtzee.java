package org.kata;

public class Yahtzee {
    private final Scoreboard scoreboard;
    private final CombinationFactory combinationFactory;

    public Yahtzee() {
        this.scoreboard = new Scoreboard();
        this.combinationFactory = new CombinationFactory();
    }

    public static Yahtzee start() {
        return new Yahtzee();
    }

    public int place(Roll roll, Category category) {
        var combination = combinationFactory.combinationFor(category);
        var score = combination.score(roll);
        scoreboard.track(score, category);
        return score;
    }
}