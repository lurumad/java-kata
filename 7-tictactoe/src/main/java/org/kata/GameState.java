package org.kata;

public record GameState(Player player, State state) {
    public static GameState winner(Player player) {
        return new GameState(player, State.Winner);
    }

    public static GameState onGoing(Player player) {
        return new GameState(player, State.OnGoing);
    }

    public static GameState from(Player player, State state) {
        return new GameState(player, state);
    }

    public enum State {
        OnGoing,
        Draw,
        Winner
    }
}
