package com.samf90.espnfantasywrapper.model.json.league;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

record JsonTeam(
        @JsonProperty("abbrev") String abbrev,
        @JsonProperty("id") int id,
        @JsonProperty("owners") List<String> owners) {
}
