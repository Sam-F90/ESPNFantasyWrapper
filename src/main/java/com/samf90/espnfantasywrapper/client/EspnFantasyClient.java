package com.samf90.espnfantasywrapper.client;

import com.samf90.espnfantasywrapper.model.api.BoxScore.BoxScore;
import com.samf90.espnfantasywrapper.model.api.teams.Teams;

public interface EspnFantasyClient {
    BoxScore getBoxScore (int year, int week);
    Teams getTeams(int year);

}