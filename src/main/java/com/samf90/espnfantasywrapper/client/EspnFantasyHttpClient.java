package com.samf90.espnfantasywrapper.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samf90.espnfantasywrapper.mapper.BoxScoreMapper;
import com.samf90.espnfantasywrapper.mapper.TeamsMapper;
import com.samf90.espnfantasywrapper.model.api.BoxScore.BoxScore;
import com.samf90.espnfantasywrapper.model.api.teams.Teams;
import com.samf90.espnfantasywrapper.model.json.boxscore.JsonBoxScore;
import com.samf90.espnfantasywrapper.model.json.teams.JsonTeams;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class EspnFantasyHttpClient implements EspnFantasyClient {
    Map<Integer, Teams> allTeams = new HashMap<>();
    private final String BASE_URL = "https://lm-api-reads.fantasy.espn.com/apis/v3/games/ffl/seasons/";
    private final int leagueId;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public EspnFantasyHttpClient(int leagueId){
        this.leagueId = leagueId;
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public BoxScore getBoxScore(int year, int week) {
        String url = BASE_URL + year + "/segments/0/leagues/" + leagueId + "?view=mMatchup&view=mMatchupScore&scoringPeriodId=" + week;
        String filterValue = String.format("{\"schedule\":{\"filterMatchupPeriodIds\":{\"value\":[%s]}}}",week);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")  // Add necessary headers
                .header("x-fantasy-filter", filterValue)
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            JsonNode boxScoreNode = objectMapper.readTree(response.body());

            JsonBoxScore jsonBoxScore = objectMapper.treeToValue(boxScoreNode, JsonBoxScore.class);
            Teams teams = getTeams(year);
            return BoxScoreMapper.mapBoxScore(jsonBoxScore,year,week,teams);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Teams getTeams(int year) {
        if(allTeams.containsKey(year)){
            return allTeams.get(year);
        }
        String url = BASE_URL + year + "/segments/0/leagues/" + leagueId + "?view=mRoster&view=mTeam";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")  // Add necessary headers
                .build();

        try{
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            JsonNode teamsNode = objectMapper.readTree(response.body());

            JsonTeams jsonTeams = objectMapper.treeToValue(teamsNode, JsonTeams.class);
            return TeamsMapper.mapTeams(jsonTeams);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
