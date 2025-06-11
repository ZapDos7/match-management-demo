package com.example.demo.domain;

import com.example.demo.domain.enums.Specifier;
import com.example.demo.domain.enums.converters.SpecifierConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "match_odds")
public class MatchOdds {
    private long id;
    private long matchId;
    private Specifier specifier;
    private double odd;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "match_id")
    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    @Column(name = "specifier")
    @Convert(converter = SpecifierConverter.class)
    public Specifier getSpecifier() {
        return specifier;
    }

    public void setSpecifier(Specifier specifier) {
        this.specifier = specifier;
    }

    @Column(name = "odd")
    public double getOdd() {
        return odd;
    }

    public void setOdd(double odd) {
        this.odd = odd;
    }
}