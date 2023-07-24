package com.info.service.implement;

import java.util.List;

import com.info.domain.Player.Player;
import com.info.service.PlayerService;

public class PlayerServiceImpl implements PlayerService {
    public List<Player> players;

    @Override
    public Player createPlayer(Player player) {
        return player;
    } 
}
