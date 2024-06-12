package org.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RaidServiceTest extends RaidService {
    GuildMember activePlayer = null;

    @Test
    void when_no_active_player_returns_an_error() {
        assertThrows(NullPointerException.class, () -> getRaidsByGuildMember(new GuildMember()));
    }

    @Override
    protected GuildMember findActivePlayer() {
        return null;
    }
}
