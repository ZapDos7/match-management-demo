package com.example.demo.web.resources.translator;

import com.example.demo.domain.MatchOdds;
import com.example.demo.web.resources.MatchOddsResource;

import java.util.ArrayList;
import java.util.List;

public class MatchOddsResourceTranslator {
    private MatchOddsResourceTranslator() {}
    
    public static MatchOddsResource toResource(MatchOdds matchOdds) {
        MatchOddsResource resource = new MatchOddsResource();
        resource.setId(matchOdds.getId());
        resource.setSpecifier(matchOdds.getSpecifier().toString());
        resource.setOdd(matchOdds.getOdd());
        return resource;
    }

    public static List<MatchOddsResource> toListResources(List<MatchOdds> matchList) {
        List<MatchOddsResource> resources = new ArrayList<>();
        matchList.forEach(m -> resources.add(toResource(m)));
        return resources;
    }
}
