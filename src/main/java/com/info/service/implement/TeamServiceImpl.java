package com.info.service.implement;

import java.util.ArrayList;
import java.util.List;

import com.info.domain.Team;
import com.info.domain.Coach.Coach;
import com.info.domain.Player.Player;
import com.info.service.TeamService;

public class TeamServiceImpl implements TeamService {
    private List<Team> teams = new ArrayList<>();
    private List<Coach> coaches = new ArrayList<>();
    private List<Player> players = new ArrayList<>();

    @Override
    public String createTeam(Team team) {
        teams.add(team);
        return "Team created successfully";
    }

    @Override
    public List<Team> getTeams() {
        return teams;
    }

    @Override
    public Team getTeamByName(String name) {
        for (Team team : teams) {
            if (team.getName().equals(name)) {
                return team;
            }
        }
        return null;
    }

    @Override
    public String deleteTeam(Team team) {
        teams.remove(team);
        return "Team deleted successfully";
    }

    @Override
    public Team AddPlayerToTeam(Team team, Player player) {
       team.getPlayers().add(player);
       return team;
    }

    @Override
    public List<Coach> getTeamCoaches() {
        for (Team team : teams) {
            Coach coach = team.getCoach();
            coaches.add(coach);
        }

        return coaches;
    }

    @Override
    public List<Player> getTeamPlayers() {
        for (Team team : teams) {
            List<Player> teamPlayers = team.getPlayers();
            for (Player player : teamPlayers) {
                players.add(player);
            }
        }
        return players;
    }
}