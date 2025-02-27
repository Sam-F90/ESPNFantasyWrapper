package com.samf90.espnfantasywrapper.model.json.boxscore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JsonRosterForCurrentScoringPeriod(
        @JsonProperty("entries") List<JsonEntries> entries
) {
}
