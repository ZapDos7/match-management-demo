package com.example.demo.service;

import com.example.demo.domain.Match;
import com.example.demo.domain.MatchOdds;
import com.example.demo.domain.enums.Specifier;
import com.example.demo.domain.enums.SportType;
import com.example.demo.domain.repository.MatchRepository;
import com.example.demo.web.request.CreateMatchOddsRequest;
import com.example.demo.web.request.CreateMatchRequest;
import com.example.demo.web.request.UpdateMatchRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MatchService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final MatchRepository matchRepository;
    private final MatchOddsService matchOddsService;

    public MatchService(MatchRepository matchRepository, MatchOddsService matchOddsService) {
        this.matchRepository = matchRepository;
        this.matchOddsService = matchOddsService;
    }

    public Page<Match> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        logger.trace("Fetching matches for page {}", pageable);
        return matchRepository.findAll(pageable);
    }

    public Match getOne(long id) {
        logger.trace("Fetching a match");
        return matchRepository.findById(id).orElseGet(() -> {
            logger.error("Could not find match with id {}", id);
            return null; // error handling todo
        });
    }

    //
    public Match createOdds(long id, CreateMatchOddsRequest request) {
        Match match = getOne(id);

        // db level validation
        boolean exists = match.getMatchOdds().stream()
                .anyMatch(o -> o.getSpecifier().equals(request.getSpecifier()));
        if (exists) {
            throw new IllegalArgumentException("Odds with this specifier already exist for the match");
        }

        // add odds
        MatchOdds odds = new MatchOdds();
        odds.setMatch(match); // set the owning side
        odds.setSpecifier(Specifier.fromLabel(request.getSpecifier()));
        odds.setOdd(request.getOdd());

        match.getMatchOdds().add(odds);
        // return
        return matchRepository.save(match);
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

    public Match deleteMatchOddsById(long matchId, long matchOddsId) {
        MatchOdds matchOdds = matchOddsService.getById(matchOddsId);
        // verify
        if (matchOdds.getMatch().getId() != matchId) {
            throw new IllegalArgumentException("Odds do not belong to this match");
        }
        // delete
        matchOddsService.deleteMatchOdds(matchOddsId);
        // return updated match
        return getOne(matchId);
    }

    public Match deleteAllMatchOdds(long id) {
        matchOddsService.deleteAllMatchOddsByMatchId(id);
        // return updated match
        return getOne(id);
    }

    public void deleteAll() {
        logger.trace("Deleting all matches");
        matchRepository.deleteAll();
    }
}