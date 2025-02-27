package com.samf90.espnfantasywrapper.mapper;

import com.samf90.espnfantasywrapper.model.api.teams.Team;
import com.samf90.espnfantasywrapper.model.api.teams.Teams;
import com.samf90.espnfantasywrapper.model.json.teams.JsonTeam;
import com.samf90.espnfantasywrapper.model.json.teams.JsonTeams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TeamsMapper {
    public static Teams mapTeams(JsonTeams jsonTeams) {
        List<Team> teamList = jsonTeams.teams().stream()
                .map(TeamsMapper::mapTeam)  // Convert each JsonTeam to Team
                .collect(Collectors.toList());

        Map<String, Team> teamMap = teamList.stream()
                .collect(Collectors.toMap(Team::id, team -> team));
        return new Teams(teamMap,teamList);
    }

    private static Team mapTeam(JsonTeam jsonTeam) {
        return new Team(
                jsonTeam.abbrev(),
                jsonTeam.logo(),
                jsonTeam.name(),
                jsonTeam.id()
        );
    }
}
