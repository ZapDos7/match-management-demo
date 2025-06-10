package com.example.demo.service;

import com.example.demo.domain.Match;
import com.example.demo.domain.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAll() {
        return matchRepository.findAll();
    }
}