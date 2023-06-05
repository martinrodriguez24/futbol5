package com.info.services;

import java.util.ArrayList;
import java.util.List;

import com.info.models.Team;
import com.info.models.Player.Player;

public class TeamService {
    private List<Team> teams;

    public TeamService() {
        teams = new ArrayList<>();
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public List<Team> getAllTeams() {
        return teams;
    }

    public Team getTeamByName(String name) {
        List<Team> teams = getAllTeams();
        for (Team team : teams) {
            if (name == team.getName()) {
                return team;
            }
        }
        return null;
    }

    public void removeTeam(Team team) {
        teams.remove(team);
    }

    public void getTeamAndRemove(String name) {
        Team team = getTeamByName(name);
        removeTeam(team);
    }

    public void AddPlayerToTeam(Team team, Player player) {
        team.addPlayer(player);
    }
}
