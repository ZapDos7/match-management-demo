package com.example.demo.web.resources.translator;

import com.example.demo.domain.Match;
import com.example.demo.web.resources.MatchResource;
import org.springframework.data.domain.Page;

public class MatchResourceTranslator {
    private MatchResourceTranslator() {}
    
    public static MatchResource toResource(Match match) {
        MatchResource resource = new MatchResource();
        resource.setId(match.getId());
        resource.setDescription(match.getDescription());
        resource.setDate(match.getDate());
        resource.setTime(match.getTime());
        resource.setTeamA(match.getTeamA());
        resource.setTeamB(match.getTeamB());
        resource.setSport(match.getSport().toString());
        resource.setOdds(MatchOddsResourceTranslator.toListResources(match.getMatchOdds()));
        return resource;
    }

    public static Page<MatchResource> toPageResources(Page<Match> matchPage) {
        return matchPage.map(MatchResourceTranslator::toResource);
    }
}
