package com.example.demo.service;

import com.example.demo.domain.MatchOdds;
import com.example.demo.domain.enums.Specifier;
import com.example.demo.domain.repository.MatchOddsRepository;
import com.example.demo.web.request.CreateMatchOddsRequest;
import com.example.demo.web.request.UpdateMatchOddsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchOddsService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final MatchOddsRepository matchOddsRepository;

    public MatchOddsService(MatchOddsRepository matchOddsRepository) {
        this.matchOddsRepository = matchOddsRepository;
    }

    public List<MatchOdds> getAll() {
        logger.trace("Fetching all match odds");
        return matchOddsRepository.findAll();
    }

    public MatchOdds getOne(long id) {
        logger.trace("Fetching match odds with id {}", id);
        return matchOddsRepository.findById(id).orElseGet(() -> {
            logger.error("Could not find match odds with id {}", id);
            return null; // error handling todo
        });
    }

    public MatchOdds createMatchOdds(CreateMatchOddsRequest request) {
        logger.trace("Creating a new match");
        return matchOddsRepository.save(new MatchOdds(request.getMatchId(),
                Specifier.fromLabel(request.getSpecifier()),
                request.getOdd()));
    }

    public MatchOdds updateMatchOdds(long id, UpdateMatchOddsRequest request) {
        logger.trace("Updating match odds with id {}", id);
        var matchOdds = getOne(id);
        if (request.getMatchId() != null) {
            matchOdds.setMatchId(request.getMatchId());
        }
        if (request.getSpecifier() != null) {
            matchOdds.setSpecifier(Specifier.fromLabel(request.getSpecifier()));
        }
        if (request.getOdd() != null) {
            matchOdds.setOdd(request.getOdd());
        }
        return matchOddsRepository.save(matchOdds);
    }

    public void deleteMatchOdds(long id) {
        logger.trace("Deleting match odds with id {}", id);
        matchOddsRepository.deleteById(id);
    }

    public void deleteAllMatchOdds() {
        logger.trace("Deleting all match odds");
        matchOddsRepository.deleteAll();
    }
}
