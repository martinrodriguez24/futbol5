package com.info.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.info.controller.form.PlayerFormController;
import com.info.domain.Player.Player;
import com.info.domain.Player.PlayerDataSheet;
import com.info.domain.Player.PlayerStats;
import com.info.domain.Player.Position;
import com.info.repository.PlayerRepository;
import com.info.repository.implement.PlayerRepositoryImpl;
import com.info.service.PlayerService;
import com.info.service.PositionService;
import com.info.service.implement.PlayerServiceImpl;
import com.info.service.implement.PositionServiceImpl;

public class PlayerController {
        private PlayerService playerService = new PlayerServiceImpl();
        private PositionService positionService = new PositionServiceImpl();
        private PlayerFormController playerForm = new PlayerFormController();
        private PlayerRepository playerRepository = new PlayerRepositoryImpl();

        private Player createPlayer(Player player) {
                return playerService.createPlayer(player);
        }

        public Player createPlayerByForm() {
                Player player = playerForm.createPlayerByForm();
                return createPlayer(player);
        }

        public List<Player> createPlayersByForm() {
                List<Player> players = new ArrayList<>();
                for (int i = 0; i < 2; i++) {
                        System.out.println("create PLAYER [" + (i + 1) + "] OF 5");
                        Player player = createPlayerByForm();
                        players.add(player);
                }
                return players;
        }

        private String getPlayer(Player player) {
                String data;
                data = "\nID: " + player.getPlayerDataSheet().getId() +
                                "\nName: " + player.getName() +
                                "\nShirt number: "
                                + player.getPlayerDataSheet().getNumberOfShirt() +
                                "\nPosition: "
                                + player.getPlayerDataSheet().getPosition().getName() +
                                "\nheight: " + player.getPlayerDataSheet().getHeight() +
                                "\nNumber of matches: "
                                + player.getPlayerStats().getNumberOfMatches() +
                                "\nNumber of goals: "
                                + player.getPlayerStats().getNumberOfGoals();

                return data;
        }

        public String getPlayers(List<Player> players) {
                String data = "";
                if (players != null) {
                        for (Player player : players) {
                                data = data + getPlayer(player) + "\n";
                        }
                        return data;
                }
                data = "players not found";
                return data;
        }

        public void savePlayers(List<Player> players) throws IOException {
                playerRepository.SavePlayers(players);
        }

        private Player loadPlayer(String[] data) {
                if (data.length < 1) {
                        return null;
                }
                UUID uuid = UUID.randomUUID();
                String name = data[1];
                int height = Integer.parseInt(data[2]);
                int numberOfShirt = Integer.parseInt(data[3]);
                Position position = positionService.getPositionByName(data[4]);
                int numberOfGoals = Integer.parseInt(data[5]);
                int numberOfMatches = Integer.parseInt(data[6]);

                PlayerDataSheet dataSheet = new PlayerDataSheet(uuid, height, numberOfShirt, position);
                PlayerStats stats = new PlayerStats(numberOfGoals, numberOfMatches);
                Player player = new Player(name, dataSheet, stats);

                return player;
        }

        public List<List<Player>> loadPlayers() throws IOException {
                List<String[]> playersData = playerRepository.loadPlayers();
                List<List<Player>> allPlayers = new ArrayList<>();
                List<Player> playersOfTeam = new ArrayList<>();

                for (int i = 0; i < playersData.size(); i++) {
                        Player player = loadPlayer(playersData.get(i));
                        if (player != null) {
                                playersOfTeam.add(player);
                                if ((i + 1) % 5 == 0) {
                                        allPlayers.add(playersOfTeam);
                                        playersOfTeam = new ArrayList<>();
                                }
                        }
                }
                return allPlayers;
        }
}