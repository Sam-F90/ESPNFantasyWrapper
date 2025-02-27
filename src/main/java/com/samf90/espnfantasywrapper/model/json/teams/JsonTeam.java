package com.samf90.espnfantasywrapper.model.json.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JsonTeam(
        @JsonProperty("abbrev") String abbrev,
        @JsonProperty("logo") String logo,
        @JsonProperty("name") String name,
        @JsonProperty("id") String id){
}
