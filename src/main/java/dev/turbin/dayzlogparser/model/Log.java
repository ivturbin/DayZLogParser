package dev.turbin.dayzlogparser.model;

import java.time.LocalTime;

public abstract class Log {
    private final LocalTime time;

    Log(LocalTime time) {
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }

}
