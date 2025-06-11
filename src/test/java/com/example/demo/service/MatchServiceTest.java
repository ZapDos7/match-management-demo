package com.example.demo.service;

import com.example.demo.domain.Match;
import com.example.demo.domain.repository.MatchRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

@SpringBootTest
class MatchServiceTest {

    @Autowired
    private MatchService matchService;

    @MockitoBean
    private MatchRepository matchRepository;

    @Test
    void getOne_returnsMatch() {
        long id = 1L;
        Match match = new Match();
        match.setId(id);
        Mockito.when(matchRepository.findById(id)).thenReturn(Optional.of(match));

        Match found = matchService.getOne(id);
        Assertions.assertEquals(id, found.getId());
    }
}
