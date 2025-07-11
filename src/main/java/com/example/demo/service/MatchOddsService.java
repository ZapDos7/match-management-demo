package com.example.demo.service;

import com.example.demo.domain.MatchOdds;
import com.example.demo.domain.repository.MatchOddsRepository;
import com.example.demo.web.errors.exceptions.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MatchOddsService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final MatchOddsRepository matchOddsRepository;

    public MatchOddsService(MatchOddsRepository matchOddsRepository) {
        this.matchOddsRepository = matchOddsRepository;
    }

    // get
    public MatchOdds getById(long id) {
        logger.trace("Fetching a match");
        return matchOddsRepository.findById(id).orElseThrow(() -> {
            logger.error("Could not find match odds with id {}", id);
            return new EntityNotFoundException("Match odds", id);
        });
    }
    // create

    // update

    // delete
    @Transactional
    public void deleteAllMatchOddsByMatchId(long matchId) {
        logger.trace("Deleting match odds for match with id {}", matchId);
        matchOddsRepository.deleteByMatchId(matchId);
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
