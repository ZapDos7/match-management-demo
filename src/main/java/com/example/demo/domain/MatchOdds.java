package com.example.demo.domain;

import com.example.demo.domain.enums.Specifier;
import com.example.demo.domain.enums.converters.SpecifierConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "match_odds", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"match_id", "specifier"})
})
public class MatchOdds {
    private long id;
    private Match match;
    private Specifier specifier;
    private double odd;

    public MatchOdds() {
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "match_id", nullable = false)
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
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