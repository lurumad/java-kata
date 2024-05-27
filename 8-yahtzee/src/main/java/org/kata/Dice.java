package org.kata;

public enum Dice {
    One(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6);

    private final int value;

    Dice(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
