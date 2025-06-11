package com.example.demo.domain.enums;

public enum Specifier {
    HOME_TEAM_WINS("1"),
    DRAW("X"),
    AWAY_TEAM_WINS("2"),
    HOME_WIN_OR_DRAW("1X"),
    DRAW_OR_AWAY_WIN("X2"),
    HOME_OR_AWAY_WIN("12"),
    OVER_2_5_GOALS("02.5"),
    UNDER_2_5_GOALS("U2.5");

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
