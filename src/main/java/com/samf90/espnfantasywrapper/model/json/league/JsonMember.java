package com.samf90.espnfantasywrapper.model.json.league;

import com.fasterxml.jackson.annotation.JsonProperty;

record JsonMember(
        @JsonProperty("displayName") String displayName,
        @JsonProperty("id") String id,
        @JsonProperty("isLeagueManager") boolean isLeagueManager) {
}

