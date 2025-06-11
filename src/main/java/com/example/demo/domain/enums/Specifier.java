package com.example.demo.domain.enums;

public enum Specifier {
    HOME_TEAM_WINS("1"),
    DRAW("X"),
    AWAY_TEAM_WINS("2");

    public final String label;

    Specifier(String label) {
        this.label = label;
    }

    public static Specifier fromLabel(String label) {
        for (Specifier s : values()) {
            if (s.label.equals(label)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown label: " + label);
    }
}
