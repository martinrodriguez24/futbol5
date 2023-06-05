package com.info.controllers;

import java.io.IOException;
import java.util.List;

import com.info.models.Coach;
import com.info.models.Team;
import com.info.models.Player.Player;
import com.info.utils.ControllerInitUtil;

public class LoadTeamsController {
    FileReaderController reader = new FileReaderController();
    private ControllerInitUtil initializator = ControllerInitUtil.getInstance();
    PlayerController playerController = initializator.getPlayerController();
    CoachController coachController = initializator.getCoachController();
    TeamController teamController = initializator.getTeamController();

    public void LoadTeamFromTable() throws IOException {
        String filePath = "src/main/java/com/info/resources/data/teams.csv";

        List<String[]> teamsTable = reader.readFile(filePath);

        for (String[] row : teamsTable) {
            teamController.LoadTeam(row[0]);
        }
        LoadPlayersOfTeam();
        LoadCoachOfTeam();
    }

    private Team getTeamToAddData(String name) {
        return teamController.getTeamByName(name);
    }

    private boolean TeamIsFound(Team team) {
        if (team != null) {
            return true;
        }
        return false;
    }

    private void LoadPlayersOfTeam() throws IOException {
        String filePath = "src/main/java/com/info/resources/data/players.csv";

        List<String[]> playersTable = reader.readFile(filePath);
        for (String[] row : playersTable) {

            Team team = getTeamToAddData(row[0]);

            if (TeamIsFound(team)) {
                Player player = PlayerController.createPlayerWithArray(row);
                teamController.LoadPlayersOfTeam(team, player);
            }
        }
    }

    private void LoadCoachOfTeam() throws IOException {
        String filePath = "src/main/java/com/info/resources/data/coaches.csv";

        List<String[]> coachesTable = reader.readFile(filePath);

        for (String[] row : coachesTable) {

            Team team = getTeamToAddData(row[0]);
            if (TeamIsFound(team)) {
                Coach coach = CoachController.createCoachWithArray(row);
                teamController.LoadCoachOfTeam(team, coach);
            }
        }
    }
}
