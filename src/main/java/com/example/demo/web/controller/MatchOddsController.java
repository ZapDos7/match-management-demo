package com.example.demo.web.controller;

import com.example.demo.domain.MatchOdds;
import com.example.demo.service.MatchOddsService;
import com.example.demo.web.request.CreateMatchOddsRequest;
import com.example.demo.web.request.UpdateMatchOddsRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Match Odds", description = "Manage match odds")
@RestController
@RequestMapping("/match-odds")
public class MatchOddsController {
    private final MatchOddsService matchOddsService;

    public MatchOddsController(MatchOddsService matchOddsService) {
        this.matchOddsService = matchOddsService;
    }

    @Operation(summary = "Get all match odds")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MatchOdds> getAllMatches() {
        return matchOddsService.getAll();
    }

    @Operation(summary = "Create match odds")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MatchOdds createMatch(@RequestBody CreateMatchOddsRequest request) {
        return matchOddsService.createMatchOdds(request);
    }

    @Operation(summary = "Update match odds")
    @PatchMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public MatchOdds updateMatch(@PathVariable long id, @RequestBody UpdateMatchOddsRequest request) {
        return matchOddsService.updateMatchOdds(id, request);
    }

    @Operation(summary = "Delete match odds")
    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMatch(@PathVariable long id) {
        matchOddsService.deleteMatchOdds(id);
    }

    @Operation(summary = "Delete all matches odds")
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll() {
        matchOddsService.deleteAllMatchOdds();
    }
}
