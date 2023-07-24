package com.info.controller.form;

import com.info.domain.Player.Player;
import com.info.domain.Player.PlayerDataSheet;
import com.info.domain.Player.PlayerStats;
import com.info.util.InputValidatorUtil;

public class PlayerFormController {
    private InputValidatorUtil validator = new InputValidatorUtil();
    private PlayerDataSheetFormController dataSheetForm = new PlayerDataSheetFormController();
    private PlayerStatsFormController statsForm = new PlayerStatsFormController();

    public Player createPlayerByForm() {
        System.out.println("CREATING NEW PLAYER");

        String name = name();
        PlayerDataSheet playerDataSheet = dataSheetForm.createPlayerDataSheetByForm();
        PlayerStats playerStats = statsForm.createPlayerStatsByForm();
        Player player = new Player(name, playerDataSheet, playerStats);

        return player;
    }    

    public String name() {
        String name = validator.validateString(
                "ENTER NAME",
                "ENTER A VALID NAME",
                2,
                255);
        return name;
    }
}
