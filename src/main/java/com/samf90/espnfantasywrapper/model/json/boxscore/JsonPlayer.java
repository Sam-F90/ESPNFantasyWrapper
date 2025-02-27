package com.samf90.espnfantasywrapper.model.json.boxscore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JsonPlayer(
        @JsonProperty("fullName") String fullName,
        @JsonProperty("id") String id,
        @JsonProperty("defaultPositionId") int defaultPositionId,
        @JsonProperty("injured") Boolean injured,
        @JsonProperty("eligibleSlots") List<Integer> eligibleSlots
) {
}
