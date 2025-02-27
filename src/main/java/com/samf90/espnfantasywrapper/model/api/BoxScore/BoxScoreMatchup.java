package com.samf90.espnfantasywrapper.model.api.BoxScore;

import java.util.List;

public record BoxScoreMatchup(
    String home,
    String away,
    String winner,
    float homeScore,
    float awayScore,
    List<BoxScorePlayer> homePlayers,
    List<BoxScorePlayer> awayPlayers){
}
