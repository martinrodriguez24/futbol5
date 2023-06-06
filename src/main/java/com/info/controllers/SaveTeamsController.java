package com.info.controllers;

import java.io.FileNotFoundException;
import java.util.List;

import com.info.utils.ControllerInitUtil;

public class SaveTeamsController {
    FileReaderController reader = new FileReaderController();
    private ControllerInitUtil initializator = ControllerInitUtil.getInstance();
    PlayerController playerController = initializator.getPlayerController();
    CoachController coachController = initializator.getCoachController();
    TeamController teamController = initializator.getTeamController();
    FileWriterController writer = new FileWriterController();

    public void saveAllTeams() throws FileNotFoundException {
        List<String> teamsData = TeamController.formatTeamsDataToSave();
        String filePath = "src/main/java/com/info/resources/data/teams.csv";
        writer.writeFile(filePath, teamsData);

        saveAllPlayers();
        saveAllCoaches();
    }

    private void saveAllPlayers() throws FileNotFoundException {
        List<String> playersData = teamController.formatPlayersDataToSave();
        String filePath = "src/main/java/com/info/resources/data/players.csv";

        writer.writeFile(filePath, playersData);
    }

    private void saveAllCoaches() throws FileNotFoundException {
        List<String> coachesData = teamController.formatCoachesDataToSave();
        String filePath = "src/main/java/com/info/resources/data/coaches.csv";

        writer.writeFile(filePath, coachesData);
    }
}