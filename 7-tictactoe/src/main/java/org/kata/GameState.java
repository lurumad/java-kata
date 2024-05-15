package org.kata;

public record GameState(Player player) {
    public static GameState inProgress() {
        return new GameState(Player.X);
    }
}
