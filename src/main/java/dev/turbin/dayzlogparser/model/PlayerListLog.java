package dev.turbin.dayzlogparser.model;

import java.time.LocalTime;

public class PlayerListLog extends Log {

    private final int playersCount;

    public PlayerListLog(LocalTime time, int playersCount) {
        super(time);
        this.playersCount = playersCount;
    }

    public int getPlayersCount() {
        return playersCount;
    }

    @Override
    public String toString() {
        return "PlayerListLog{" +
                "time: " + this.getTime() + ", " +
                "playersCount=" + playersCount +
                '}';
    }
}
