package com.example.demo.web.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalTime;

public class CreateMatchRequest {
    private String description;
    private LocalDate date;
    private LocalTime time;
    @NotBlank(message = "Must provide team name")
    private String teamA;
    @NotBlank(message = "Must provide team name")
    private String teamB;
    @Min(value = 1, message = "Sport must be at least 1 (FOOTBALL)")
    @Max(value = 3, message = "Sport must be at most 2 (BASKETBALL)")
    private int sport;

    public CreateMatchRequest() {
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
