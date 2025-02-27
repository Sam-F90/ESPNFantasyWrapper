package com.samf90.espnfantasywrapper.model.api.teams;

import java.util.List;
import java.util.Map;

public record Teams(
        Map<String, Team> teamMap,
        List<Team> teams){
}
