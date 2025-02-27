package com.samf90.espnfantasywrapper.model.api.BoxScore;

import java.util.List;

public record BoxScore(
        int year,
        int week,
    List<BoxScoreMatchup> matchups){
}
