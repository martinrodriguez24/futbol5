package com.info.repository;

import java.io.IOException;
import java.util.List;

import com.info.domain.Player.Player;

public interface PlayerRepository {
    public List<String[]> loadPlayers() throws IOException;

    public void SavePlayers(List<Player> players) throws IOException;
}
