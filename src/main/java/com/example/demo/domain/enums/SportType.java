package com.example.demo.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum SportType {
    FOOTBALL(1), BASKETBALL(2);

    public final int label;

    private static final Map<Integer, SportType> lookup = new HashMap<>();

    static {
        for (SportType sport : SportType.values()) {
            lookup.put(sport.label, sport);
        }
    }

    private SportType(int label) {
        this.label = label;
    }

    public static SportType fromInt(int sport) {
        SportType result = lookup.get(sport);
        if (result == null) {
            throw new IllegalArgumentException("Invalid sport label: " + sport);
        }
        return result;
    }
}
