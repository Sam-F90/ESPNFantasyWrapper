package com.samf90.espnfantasywrapper.model.json.boxscore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JsonTeam(
        @JsonProperty("teamId") String teamId,
        @JsonProperty("tiebreak") String tiebreak,
        @JsonProperty("totalPoints") String totalPoints,
        @JsonProperty("rosterForCurrentScoringPeriod") JsonRosterForCurrentScoringPeriod jsonRosterForCurrentScoringPeriod)
{}
