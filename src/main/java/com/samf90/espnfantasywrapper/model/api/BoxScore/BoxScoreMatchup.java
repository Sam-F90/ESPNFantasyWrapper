package com.samf90.espnfantasywrapper.model.api.BoxScore;

import com.samf90.espnfantasywrapper.model.api.teams.Team;

import java.util.List;

public record BoxScoreMatchup(
    Team home,
    Team away,
    Team winner,
    Team loser,
    float homeScore,
    float awayScore,
    List<BoxScorePlayer> homePlayers,
    List<BoxScorePlayer> awayPlayers){
}
