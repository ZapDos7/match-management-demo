package com.example.demo.web.controller;

import com.example.demo.domain.Match;
import com.example.demo.service.MatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Match> getAllMatches() {
        return matchService.getAll();
    }

    // CRUD using HTTP verbs
}
