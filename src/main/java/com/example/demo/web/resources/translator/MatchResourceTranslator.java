package com.example.demo.web.resources.translator;

import com.example.demo.domain.Match;
import com.example.demo.web.resources.MatchResource;

import java.util.ArrayList;
import java.util.List;

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
        return resource;
    }

    public static List<MatchResource> toListResources(List<Match> matchList) {
        List<MatchResource> resources = new ArrayList<>();
        matchList.forEach(m -> resources.add(toResource(m)));
        return resources;
    }
}
