package com.example.demo.domain.enums;

public enum SportType {
    FOOTBALL(1), BASKETBALL(2);

    public final int label;

    private SportType(int label) {
        this.label = label;
    }
}
