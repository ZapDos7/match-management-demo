package com.example.demo.web.controller;

import com.example.demo.domain.Match;
import com.example.demo.domain.enums.SportType;
import com.example.demo.service.MatchService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MatchController.class)
class MatchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MatchService matchService;

    @Test
    void getMatchById_returnsMatch() throws Exception {
        long matchId = 1L;
        Match match = new Match();
        match.setId(matchId);
        match.setDescription("Test Match");
        match.setSport(SportType.BASKETBALL);
        match.setTime(LocalTime.now());
        match.setDate(LocalDate.now());
        match.setTeamB("Team B");
        match.setTeamA("Team A");

        Mockito.when(matchService.getOne(matchId)).thenReturn(match);

        mockMvc.perform(get("/matches/{id}", matchId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("Test Match"));
    }
}
