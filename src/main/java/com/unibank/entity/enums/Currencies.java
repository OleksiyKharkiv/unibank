package com.unibank.entity.enums;

public enum Currencies {
    EUR(0),
    USD(1),
    CHF(2),
    PLN(3),
    GBP(4),
    UAH(5);
    private final int value;

    Currencies(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}