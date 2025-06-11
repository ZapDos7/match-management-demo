package com.example.demo.web.controller;

import com.example.demo.service.MatchService;
import com.example.demo.web.request.CreateMatchOddsRequest;
import com.example.demo.web.request.CreateMatchRequest;
import com.example.demo.web.request.UpdateMatchRequest;
import com.example.demo.web.resources.MatchResource;
import com.example.demo.web.resources.translator.MatchResourceTranslator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Matches", description = "Manage matches")
@RestController
@RequestMapping("/matches")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    // Get

    @Operation(summary = "Get all matches")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MatchResource> getAllMatches() {
        return MatchResourceTranslator.toListResources(matchService.getAll());
    }

    @Operation(summary = "Get a match's details")
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MatchResource getOneMatch(@PathVariable long id) {
        return MatchResourceTranslator.toResource(matchService.getOne(id));
    }

    // Create

    @Operation(summary = "Create a new match")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MatchResource createMatch(@RequestBody CreateMatchRequest request) {
        return MatchResourceTranslator.toResource(matchService.createMatch(request));
    }

    @Operation(summary = "Add odds to match")
    @PostMapping(path = "/{id}/odds")
    @ResponseStatus(HttpStatus.CREATED)
    public MatchResource createMatchOdds(@PathVariable long id, @RequestBody CreateMatchOddsRequest request) {
        return MatchResourceTranslator.toResource(matchService.createOdds(id, request));
    }

    // Update

    @Operation(summary = "Update a match")
    @PatchMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public MatchResource updateMatch(@PathVariable long id, @RequestBody UpdateMatchRequest request) {
        return MatchResourceTranslator.toResource(matchService.updateMatch(id, request));
    }

    // Delete

    @Operation(summary = "Delete a match")
    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMatch(@PathVariable long id) {
        matchService.deleteMatch(id);
    }

    @Operation(summary = "Delete an odds of a match")
    @DeleteMapping(path = "/{matchId}/odds/{matchOddsId}")
    @ResponseStatus(HttpStatus.OK)
    public MatchResource deleteMatchOddsById(@PathVariable long matchId, @PathVariable long matchOddsId) {
        return MatchResourceTranslator.toResource(matchService.deleteMatchOddsById(matchId, matchOddsId));
    }

    @Operation(summary = "Delete all odds of a match")
    @DeleteMapping(path = "/{id}/odds")
    @ResponseStatus(HttpStatus.OK)
    public MatchResource deleteAllMatchOdds(@PathVariable long id) {
        return MatchResourceTranslator.toResource(matchService.deleteAllMatchOdds(id));
    }

    @Operation(summary = "Delete all matches")
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll() {
        matchService.deleteAll();
    }
}
