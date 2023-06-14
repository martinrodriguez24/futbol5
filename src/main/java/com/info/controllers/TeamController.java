package com.info.controllers;

import com.info.models.Team;
import com.info.models.Player.Player;
import com.info.models.Coach;

import com.info.services.TeamService;
import com.info.utils.InputValidatorUtil;

import java.time.LocalDateTime;
import java.util.List;

public class TeamController {
    private PlayerController playerController;
    private CoachController coachController;
    private TeamService teamService = new TeamService();
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

    public void PrintAllTeams() {
        List<Team> teams = teamService.getAllTeams();

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

}
