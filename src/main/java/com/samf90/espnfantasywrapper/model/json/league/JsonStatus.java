package com.samf90.espnfantasywrapper.model.json.league;

import com.fasterxml.jackson.annotation.JsonProperty;

record JsonStatus(
        @JsonProperty("currentMatchupPeriod") int currentMatchupPeriod,
        @JsonProperty("isActive") boolean isActive,
        @JsonProperty("latestScoringPeriod") int latestScoringPeriod) {
}