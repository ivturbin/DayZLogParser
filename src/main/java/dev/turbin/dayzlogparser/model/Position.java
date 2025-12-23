package dev.turbin.dayzlogparser.model;

import java.math.BigDecimal;

public record Position(BigDecimal x, BigDecimal y, BigDecimal z) {

    @Override
    public String toString() {
        return "x=" + x +
                ", y=" + y +
                ", z=" + z;
    }
}
