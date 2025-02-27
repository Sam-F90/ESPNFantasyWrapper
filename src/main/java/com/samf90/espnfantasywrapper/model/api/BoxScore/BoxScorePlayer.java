package com.samf90.espnfantasywrapper.model.api.BoxScore;

import java.util.List;

public record BoxScorePlayer(
        int id,
        String fullName,
        float score,
        int defaultPositionID,
        int slottedPositionID,
        String defaultPositionName,
        String slottedPositionName,
        List<Integer> eligibleSlots,
        boolean injured){
}
