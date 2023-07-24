package com.info.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import com.info.controller.form.TeamFormController;
import com.info.domain.Team;
import com.info.domain.Coach.Coach;
import com.info.domain.Player.Player;
import com.info.repository.TeamRepository;
import com.info.repository.implement.TeamRepositoryImpl;
import com.info.service.TeamService;
import com.info.service.implement.TeamServiceImpl;
import com.info.util.DataParserUtil;

public class TeamController {
    private TeamFormController teamForm = new TeamFormController();
    private CoachController coachController = new CoachController();
    private PlayerController playerController = new PlayerController();
    private TeamService teamService = new TeamServiceImpl();
    private TeamRepository teamRepository = new TeamRepositoryImpl();
    private List<Team> teams;
    private DataParserUtil dataParser = new DataParserUtil();

    public String createTeamByForm() {
        Team team = teamForm.createTeamByForm();
        return createTeam(team);
    }

    private String createTeam(Team team) {
        return teamService.createTeam(team);
    }

    public String printTeam(Team team) {
        String teamName = team.getName();
        LocalDateTime createdAt = team.getCreatedAt();

        List<Player> players = team.getPlayers();
        Coach coach = team.getCoach();
        String coachData = coachController.getCoach(coach);
        String playersData = playerController.getPlayers(players);

        String data = "\nTEAM: ";

        data = data +
                "\nteam name: " + teamName +
                "\ncreated at: " + createdAt +
                "\n" + coachData +
                "\n" + coachData +
                "\n" + playersData;

        return data;
    }

    private List<Team> getTeams() {
        teams = teamService.getTeams();
        return teams;
    }

    public void printTeams() {
        teams = getTeams();

        for (Team team : teams) {
            System.out.println(printTeam(team));
        }
    }

    public void saveTeams() throws IOException {
        List<Team> teams = getTeams();
        List<Coach> coaches = teamService.getTeamCoaches();
        List<Player> players = teamService.getTeamPlayers();
        teamRepository.saveTeams(teams);
        coachController.saveCoaches(coaches);
        playerController.savePlayers(players);
    }

    public void loadTeams() throws IOException {
        List<String[]> teamsData = teamRepository.loadTeams();
        List<Coach> coaches = coachController.loadCoaches();
        List<List<Player>> allPlayers = playerController.loadPlayers();
        for (int i = 0; i < teamsData.size(); i++) {

            Coach coach = coaches.get(i);
            List<Player> players = allPlayers.get(i);
            
            // Team
            String row[] = teamsData.get(i);
            LocalDateTime createdAt = dataParser.StringToLDT(row[1]);
            String name = row[0];

            Team team = new Team(name, players, coach, createdAt);
            createTeam(team);
        }

        playerController.loadPlayers();
    }
}