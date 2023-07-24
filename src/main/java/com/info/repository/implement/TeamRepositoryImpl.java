package com.info.repository.implement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.info.domain.Team;
import com.info.repository.TeamRepository;
import com.info.util.FileReaderUtil;
import com.info.util.FileWriterUtil;

public class TeamRepositoryImpl implements TeamRepository {
    private FileReaderUtil reader = new FileReaderUtil();
    private FileWriterUtil writer = new FileWriterUtil();
    private String teamTable = "src/main/java/com/info/resources/data/team.csv";

    @Override
    public List<String[]> loadTeams() throws IOException {
        List<String[]> teamsData = reader.read(teamTable);
        return teamsData;
    }
    
    private String saveTeam(Team team) {
        String line = team.getName() + "," +
                    team.getCreatedAt();
        return line;
    }

    @Override
    public void saveTeams(List<Team> teams) throws IOException {
        List<String> columns = new ArrayList<>();
        for (Team team : teams) {
            String line = saveTeam(team);
            columns.add(line);
        }
        
        writer.writeFile(columns, teamTable);
    }
}
