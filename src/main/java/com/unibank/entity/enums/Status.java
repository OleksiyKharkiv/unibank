package com.unibank.entity.enums;

public enum Status {
    PENDING(0),
    SUCCESS(1),
    FAILED(2);
    private final int value;
    Status(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
