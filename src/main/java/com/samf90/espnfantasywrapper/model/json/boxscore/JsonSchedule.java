package com.samf90.espnfantasywrapper.model.json.boxscore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JsonSchedule(
    @JsonProperty("away") JsonTeam away,
    @JsonProperty("home") JsonTeam home,
    @JsonProperty("id") int id,
    @JsonProperty("winner") String winner
){}