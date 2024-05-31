package org.kata;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Roll {
    private final Dice [] dices;

    public Roll(Dice first, Dice second, Dice third, Dice fourth, Dice fifth) {
        this.dices = new Dice[] {first, second, third, fourth, fifth};
    }

    public int sum(Dice dice) {
        return Arrays.stream(dices)
                .filter(d -> d == dice)
                .mapToInt(d -> dice.value())
                .sum();
    }

    public int sumMaxPair() {
        return Arrays.stream(dices)
                .collect(Collectors.groupingBy(Dice::name, Collectors.summingInt(Dice::value)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(new AbstractMap.SimpleEntry<>(null, 0))
                .getValue();
    }
}
