package com.samf90.espnfantasywrapper.model.json.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JsonTeams(
        @JsonProperty("teams") List<JsonTeam> teams){
}
