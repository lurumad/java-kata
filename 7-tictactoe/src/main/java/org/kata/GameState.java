package org.kata;

public record GameState(Player player) {
    public static GameState from(Player player) {
        return new GameState(player);
    }
}
