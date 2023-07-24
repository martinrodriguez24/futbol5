package com.info.repository;

import java.io.IOException;
import java.util.List;

import com.info.domain.Team;

public interface TeamRepository {
    public List<String[]> loadTeams() throws IOException;

    public void saveTeams(List<Team> teams) throws IOException;
}
