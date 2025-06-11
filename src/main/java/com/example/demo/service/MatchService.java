package com.example.demo.service;

import com.example.demo.domain.Match;
import com.example.demo.domain.enums.SportType;
import com.example.demo.domain.repository.MatchRepository;
import com.example.demo.web.request.CreateMatchRequest;
import com.example.demo.web.request.UpdateMatchRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<Match> getAll() {
        logger.trace("Fetching all matches");
        return matchRepository.findAll();
    }

    public Match getOne(long id) {
        logger.trace("Fetching a match");
        return matchRepository.findById(id).orElseGet(() -> {
            logger.error("Could not find match with id {}", id);
            return null; // error handling todo
        });
    }

    public Match createMatch(CreateMatchRequest request) {
        logger.trace("Creating a new match");
        return matchRepository.save(new Match(request.getDescription(),
                request.getDate(),
                request.getTime(),
                request.getTeamA(),
                request.getTeamB(),
                SportType.fromInt(request.getSport())));
    }

    public Match updateMatch(long id, UpdateMatchRequest request) {
        logger.trace("Updating match with id {}", id);
        var match = getOne(id);
        if (request.getDescription() != null) {
            match.setDescription(request.getDescription());
        }
        if (request.getDate() != null) {
            match.setDate(request.getDate());
        }
        if (request.getTime() != null) {
            match.setTime(request.getTime());
        }
        if (request.getTeamA() != null) {
            match.setTeamA(request.getTeamA());
        }
        if (request.getTeamB() != null) {
            match.setTeamB(request.getTeamB());
        }
        if (request.getSport() != null) {
            match.setSport(SportType.fromInt(request.getSport()));
        }
        return matchRepository.save(match);
    }

    public void deleteMatch(long id) {
        logger.trace("Deleting match with id {}", id);
        matchRepository.deleteById(id);
    }

    public void deleteAll() {
        logger.trace("Deleting all matches");
        matchRepository.deleteAll();
    }
}