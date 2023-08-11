package com.example.leetcode.calculateSoldCredit;

public enum Currency {

    RUB(1L),
    USD(2L),
    KZT(3L),
    GEL(4L);

    private final long value;

    Currency(long v) {
        value = v;
    }

    public long value() {
        return value;
    }

}
