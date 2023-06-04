package com.info.controllers;

import java.util.List;
import java.util.UUID;

import com.info.models.Team;
import com.info.models.Player.Player;
import com.info.utils.InputValidatorUtil;

public class PlayerController {
    private InputValidatorUtil validator = new InputValidatorUtil();
    private PositionController positionController = new PositionController();

    public void createPlayer(Team team) {
        String txt, alertTxt;
        int min, max;

        Player player = new Player();
        player.getPlayerDataSheet().setId(UUID.randomUUID());
        player.getPlayerDataSheet().setPosition(positionController.selectPosition());

        txt = "player NAME";
        alertTxt = "invalid NAME, should be only with letters";
        min = 2;
        max = 255;

        player.setName(validator.validateString(txt, alertTxt, min, max));

        txt = "player SURNAME";
        alertTxt = "invalid SURNAME, should be only with letters";
        min = 2;
        max = 255;

        player.setSurname(validator.validateString(txt, alertTxt, min, max));

        txt = "player SHIRT NUMBER";
        alertTxt = "invalid SHIRT NUMBER, should be only ints [0 - 100]";
        min = 0;
        max = 100;

        player.getPlayerDataSheet().setNumberOfShirt(validator.validateInt(txt, alertTxt, min, max));

        txt = "player HEIGHT (cm)";
        alertTxt = "invalid HEIGHT, should be int :: centimeter format [100 - 250]cm";
        min = 2;
        max = 255;

        player.getPlayerDataSheet().setHeight(validator.validateInt(txt, alertTxt, min, max));

        txt = "player NUMBER OF GOALS";
        alertTxt = "invalid NUMBER, should be int [0 - 805]";
        min = 0;
        max = 805;

        player.getPlayerStats().setNumberOfGoals(validator.validateInt(txt, alertTxt, min, max));

        txt = "player NUMBER OF MATCHES";
        alertTxt = "invalid NUMBER, should be int [0 - 1000]";
        min = 0;
        max = 1000;

        player.getPlayerStats().setNumberOfGoals(validator.validateInt(txt, alertTxt, min, max));

        team.addPlayer(player);
    }

    public void createPlayersOfTeam(Team team)  {
        for (int i = 0; i < 2; i++) {
            System.out.println("create PLAYER [" +(i+1)+ "] OF 5");
            createPlayer(team);
        }
    }

    private void printPlayer(Player player) {

        System.out.println("***************************");
        String data = "ID: " + player.getPlayerDataSheet().getId() +
                "\nPlayer name: " + player.getName() + " " + player.getSurname() +
                "\nShirt number: " + player.getPlayerDataSheet().getNumberOfShirt() +
                "\nPlayer Position: " + player.getPlayerDataSheet().getPosition().getName() +
                "\nheight: " + player.getPlayerDataSheet().getHeight() + "cm" +
                "\nNumber of matches: " + player.getPlayerStats().getNumberOfMatches() +
                "\nNumber of goals: " + player.getPlayerStats().getNumberOfGoals();
        System.out.println(data);
    }

    public void printPlayersOfTeam(List<Player> players) {
        for (Player player : players) {
            printPlayer(player);
        }
    }
}
