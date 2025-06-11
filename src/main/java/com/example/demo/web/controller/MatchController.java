package com.example.demo.web.controller;

import com.example.demo.domain.Match;
import com.example.demo.service.MatchService;
import com.example.demo.web.request.CreateMatchRequest;
import com.example.demo.web.request.UpdateMatchRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "matches", description = "Manage matches")
@RestController
@RequestMapping("/matches")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @Operation(summary = "Get all matches")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Match> getAllMatches() {
        return matchService.getAll();
    }

    @Operation(summary = "Get a match's details")
    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Match getOneMatch(@PathVariable long id) {
        return matchService.getOne(id);
    }

    @Operation(summary = "Create a new match")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Match createMatch(@RequestBody CreateMatchRequest request) {
        return matchService.createMatch(request);
    }

    @Operation(summary = "Update a match")
    @PatchMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Match updateMatch(@PathVariable long id, @RequestBody UpdateMatchRequest request) {
        return matchService.updateMatch(id, request);
    }

    @Operation(summary = "Delete a match")
    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMatch(@PathVariable long id) {
        matchService.deleteMatch(id);
    }

    @Operation(summary = "Delete all matches")
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAll() {
        matchService.deleteAll();
    }
}
