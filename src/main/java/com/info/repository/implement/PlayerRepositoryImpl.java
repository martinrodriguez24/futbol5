package com.info.repository.implement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.info.domain.Player.Player;
import com.info.repository.PlayerRepository;
import com.info.util.FileReaderUtil;
import com.info.util.FileWriterUtil;

public class PlayerRepositoryImpl implements PlayerRepository {
    private FileReaderUtil reader = new FileReaderUtil();
    private FileWriterUtil writer = new FileWriterUtil();
    private String playerTable = "src/main/java/com/info/resources/data/player.csv";

    @Override
    public List<String[]> loadPlayers() throws IOException {
        List<String[]> playersData = reader.read(playerTable);
        return playersData;
    }

    private String savePlayer(Player player) {
        String line = player.getPlayerDataSheet().getId() + "," +
                player.getName() + "," +
                player.getPlayerDataSheet().getHeight() + "," +
                player.getPlayerDataSheet().getNumberOfShirt() + "," +
                player.getPlayerDataSheet().getPosition().getName() + "," +
                player.getPlayerStats().getNumberOfGoals() + "," +
                player.getPlayerStats().getNumberOfMatches();

        return line;
    }

    @Override
    public void SavePlayers(List<Player> players) throws IOException {
        List<String> columns = new ArrayList<>();
        for (Player player : players) {
            String line = savePlayer(player);
            columns.add(line);
        }
        writer.writeFile(columns, playerTable);
    }

}
