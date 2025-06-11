package com.example.demo.domain;

import com.example.demo.domain.enums.SportType;
import com.example.demo.domain.enums.converters.SportTypeConverter;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matches")
public class Match {
    private long id;
    private String description;
    private LocalDate date;
    private LocalTime time;
    private String teamA;
    private String teamB;
    private SportType sport;
    private List<MatchOdds> matchOdds = new ArrayList<>();

    public Match() {
    }

    public Match(String description, LocalDate date, LocalTime time, String teamA, String teamB, SportType sport) {
        this.description = description;
        this.date = date;
        this.time = time;
        this.teamA = teamA;
        this.teamB = teamB;
        this.sport = sport;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "match_date")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "match_time")
    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Column(name = "team_a")
    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    @Column(name = "team_b")
    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    @Column(name = "sport")
    @Convert(converter = SportTypeConverter.class)
    public SportType getSport() {
        return sport;
    }

    public void setSport(SportType sport) {
        this.sport = sport;
    }

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    public List<MatchOdds> getMatchOdds() {
        return matchOdds;
    }

    public void setMatchOdds(List<MatchOdds> matchOdds) {
        this.matchOdds = matchOdds;
    }
}