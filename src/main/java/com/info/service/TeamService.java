package com.info.service;
import java.util.List;

import com.info.domain.Team;
import com.info.domain.Coach.Coach;
import com.info.domain.Player.Player;

public interface TeamService {
    public String createTeam(Team team);

    public List<Team> getTeams();

    public Team getTeamByName(String name);

    public String deleteTeam(Team team);

    public Team AddPlayerToTeam(Team team, Player player);

    public List<Coach> getTeamCoaches();

    public List<Player> getTeamPlayers();

}
