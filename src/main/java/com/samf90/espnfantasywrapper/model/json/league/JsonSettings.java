package com.samf90.espnfantasywrapper.model.json.league;

import com.fasterxml.jackson.annotation.JsonProperty;

record JsonSettings(
        @JsonProperty("name") String name) {
}

