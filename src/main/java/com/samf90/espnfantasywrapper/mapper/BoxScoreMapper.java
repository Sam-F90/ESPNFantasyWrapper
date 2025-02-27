package com.samf90.espnfantasywrapper.mapper;

import com.samf90.espnfantasywrapper.model.api.BoxScore.BoxScore;
import com.samf90.espnfantasywrapper.model.api.BoxScore.BoxScoreMatchup;
import com.samf90.espnfantasywrapper.model.api.BoxScore.BoxScorePlayer;
import com.samf90.espnfantasywrapper.model.api.teams.Teams;
import com.samf90.espnfantasywrapper.model.json.boxscore.*;
import com.samf90.espnfantasywrapper.util.Constants;

import java.util.List;
import java.util.stream.Collectors;

public class BoxScoreMapper {
    public static BoxScore mapBoxScore(JsonBoxScore jsonBoxScore, int year, int week, Teams teams) {
        List<BoxScoreMatchup> matchups = jsonBoxScore.jsonSchedule().stream()
                .map(JsonSchedule -> mapMatchup(JsonSchedule,teams))
                .collect(Collectors.toList());

        return new BoxScore(year, week, matchups);
    }

    private static BoxScoreMatchup mapMatchup(JsonSchedule jsonSchedule, Teams teams) {
        return new BoxScoreMatchup(
                teams.teamMap().get(jsonSchedule.home().teamId()),
                teams.teamMap().get(jsonSchedule.away().teamId()),
                teams.teamMap().get(jsonSchedule.winner()),
                (jsonSchedule.winner().equals(jsonSchedule.home().teamId())) ? teams.teamMap().get(jsonSchedule.away().teamId()): teams.teamMap().get(jsonSchedule.home().teamId()),
                parseScore(jsonSchedule.home().totalPoints()),
                parseScore(jsonSchedule.away().totalPoints()),
                mapPlayers(jsonSchedule.home().jsonRosterForCurrentScoringPeriod()),
                mapPlayers(jsonSchedule.away().jsonRosterForCurrentScoringPeriod())
        );
    }

    private static List<BoxScorePlayer> mapPlayers(JsonRosterForCurrentScoringPeriod roster) {
        if (roster == null || roster.entries() == null) {
            return List.of();
        }

        return roster.entries().stream()
                .map(entry -> {
                    JsonPlayerPoolEntry playerPoolEntry = entry.jsonPlayerPoolEntry();
                    JsonPlayer player = playerPoolEntry.jsonPlayer();

                    return new BoxScorePlayer(
                            Integer.parseInt(player.id()),
                            player.fullName(),
                            (float) playerPoolEntry.appliedStatTotal(),
                            player.defaultPositionId(),
                            entry.lineupSlotId(),
                            Constants.SLOT_POSITIONS.get(player.defaultPositionId()),
                            Constants.SLOT_POSITIONS.get(entry.lineupSlotId()),
                            player.eligibleSlots(),
                            player.injured() != null && player.injured()
                    );
                })
                .collect(Collectors.toList());
    }

    private static float parseScore(String score) {
        try {
            return Float.parseFloat(score);
        } catch (NumberFormatException e) {
            return 0.0f; // Default score if parsing fails
        }
    }
}
