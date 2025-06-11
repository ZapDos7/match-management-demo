package com.example.demo.web.request;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateMatchRequest {
    private String description;
    private LocalDate date;
    private LocalTime time;
    private String teamA;
    private String teamB;
    private int sport;

    public CreateMatchRequest(String description, LocalDate date, LocalTime time, String teamA, String teamB, int sport) {
        this.description = description;
        this.date = date;
        this.time = time;
        this.teamA = teamA;
        this.teamB = teamB;
        this.sport = sport;
    }

    public CreateMatchRequest(String description, String teamA, String teamB, int sport) {
        this.description = description;
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.teamA = teamA;
        this.teamB = teamB;
        this.sport = sport;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public int getSport() {
        return sport;
    }

    public void setSport(int sport) {
        this.sport = sport;
    }
}
