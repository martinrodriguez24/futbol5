package com.info.controllers;

import com.info.models.Team;
import com.info.models.Player.Player;
import com.info.models.Coach;

import com.info.services.TeamService;
import com.info.utils.InputValidatorUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TeamController {
    private PlayerController playerController;
    private CoachController coachController;
    private static TeamService teamService = new TeamService();
    private InputValidatorUtil validator = new InputValidatorUtil();

    public TeamController(PlayerController playerController, CoachController coachController) {
        this.playerController = playerController;
        this.coachController = coachController;
    }

    public void CreateTeam() {
        String txt, alertTxt;
        int min, max;
        Team team = new Team();

        min = 2;
        max = 255;
        txt = "TEAM NAME";
        alertTxt = "Enter valid TEAM NAME [2 - 255]";

        team.setName(validator.validateString(txt, alertTxt, min, max));
        team.setCreatedAt(LocalDateTime.now());
        coachController.createCoach(team);
        playerController.createPlayersOfTeam(team);

        teamService.addTeam(team);
    }

    public List<Team> getTeams() {
        List<Team> teams = teamService.getAllTeams();
        return teams;
    }

    public void PrintAllTeams() {
        List<Team> teams = getTeams();

        for (Team team : teams) {
            System.out.println(team.getName());
            Coach coach = team.getCoach();
            List<Player> playersOfTeam = team.getPlayers();
            coachController.printCoachOfTeam(coach);
            playerController.printPlayersOfTeam(playersOfTeam);

        }
    }

    public void LoadTeam(String name) {
        Team team = new Team();
        team.setName(name);
        team.setCreatedAt(LocalDateTime.now());

        teamService.addTeam(team);
    }

    public void LoadPlayersOfTeam(Team team, Player player) {
        teamService.AddPlayerToTeam(team, player);
    }

    public void LoadCoachOfTeam(Team team, Coach coach) {
        team.setCoach(coach);
    }

    public Team getTeamByName(String name) {
        List<Team> teams = teamService.getAllTeams();

        for (Team team : teams) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        return null;
    }

    private Team searchTeamByName() {
        Team team = getTeamByName(validator.validateString("search TEAM", "err", 1, 255));
        return team;
    }

    public void searchTeamAndPrint() {
        Team team = searchTeamByName();
        team.getName();
    }

    public void removeTeamByName() {
        Team team = searchTeamByName();
        teamService.removeTeam(team);
    }

    public static List<String> formatTeamsDataToSave() {

        List<Team> teams = teamService.getAllTeams();
        List<String> data = new ArrayList<>();
        String row;

        for (Team team : teams) {
            row = "";
            row = row + team.getName();
            data.add(row);
        }
        return data;
    }

    public List<String> formatPlayersDataToSave() {
        List<Team> teams = teamService.getAllTeams();

        List<String> data = new ArrayList<>();
        for (Team team : teams) {
            List<String> playersOfTeam = formatPlayersOfTeam(team);
            for (String row : playersOfTeam) {
                data.add(row);
            }
        }
        return data;
    }

    private List<String> formatPlayersOfTeam(Team team) {

        List<String> data = new ArrayList<>();
        List<Player> players = team.getPlayers();
        String row;

        for (Player player : players) {
            row = "";
            String teamName = team.getName(),
                    name = player.getName(),
                    surname = player.getSurname(),
                    shirtNumber = Integer.toString(player.getPlayerDataSheet().getNumberOfShirt()),
                    height = Integer.toString(player.getPlayerDataSheet().getHeight()),
                    position = player.getPlayerDataSheet().getPosition().getName(),
                    goalsNumber = Integer.toString(player.getPlayerStats().getNumberOfGoals()),
                    matchesNumber = Integer.toString(player.getPlayerStats().getNumberOfMatches());

            String[] columns = {
                    teamName,
                    name,
                    surname,
                    shirtNumber,
                    height,
                    position,
                    goalsNumber,
                    matchesNumber };

            for (String column : columns) {
                row = row + column + ",";
            }
            row = row.substring(0, row.length() - 1);
            data.add(row);
        }
        return data;
    }

    public List<String> formatCoachesDataToSave() {
        List<Team> teams = teamService.getAllTeams();
        List<String> data = new ArrayList<>();
        for (Team team : teams) {
            String row = formatCoachOfTeam(team);
            data.add(row);
        }

        return data;
    }

    private String formatCoachOfTeam(Team team) {
        Coach coach = team.getCoach();
        String row;

        row = "";
        String teamName = team.getName(),
                name = coach.getName(),
                surname = coach.getSurname(),
                age = Integer.toString(coach.getAge());

        String[] columns = {
                teamName,
                name,
                surname,
                age
        };

        for (String column : columns) {
            row = row + column + ",";
        }
        row = row.substring(0, row.length() - 1);
        return row;
    }
}
