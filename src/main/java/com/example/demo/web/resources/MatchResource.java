package com.example.demo.web.resources;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MatchResource {
    private long id;
    private String description;
    private LocalDate date;
    private LocalTime time;
    private String teamA;
    private String teamB;
    private String sport;
    private List<MatchOddsResource> odds;

    public MatchResource() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public List<MatchOddsResource> getOdds() {
        return odds;
    }

    public void setOdds(List<MatchOddsResource> odds) {
        this.odds = odds;
    }
}
