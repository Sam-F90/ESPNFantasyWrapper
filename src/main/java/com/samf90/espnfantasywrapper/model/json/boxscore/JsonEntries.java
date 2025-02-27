package com.samf90.espnfantasywrapper.model.json.boxscore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record JsonEntries(
        @JsonProperty("lineupSlotId") int lineupSlotId,
        @JsonProperty("playerPoolEntry") JsonPlayerPoolEntry jsonPlayerPoolEntry
) {
}
