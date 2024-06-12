package org.kata;

import java.util.ArrayList;
import java.util.List;

public class RaidService {

    public List<Raid> getRaidsByGuildMember(GuildMember other) {
        GuildMember player = findActivePlayer();

        if (player == null) {
            throw new NullPointerException();
        }

        if (other.getFriends().contains(player)) {
            return RaidDao.findRaidsBy(other);
        }

        return new ArrayList<>();
    }

    protected GuildMember findActivePlayer() {
        return GuildDao.findActivePlayer();
    }
}

