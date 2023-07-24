package com.info.controller.form;

import com.info.domain.Player.PlayerStats;
import com.info.util.InputValidatorUtil;

public class PlayerStatsFormController {
    private InputValidatorUtil validator = new InputValidatorUtil();

    public PlayerStats createPlayerStatsByForm() {
        int numberOfGoals = playerNumberOfGoals();
        int numberOfMatches = playerNumberOfMatches();
        PlayerStats playerStats = new PlayerStats(numberOfGoals, numberOfMatches);

        return playerStats;
    }

    public int playerNumberOfGoals() {
        int numberOfGoals = validator.validateInt(
                "NUMBER OF GOALS",
                "ENTER VALID NUMBER [0-999]",
                0,
                999);

        return numberOfGoals;
    }

    public int playerNumberOfMatches() {
        int numberOfMatches = validator.validateInt(
                "NUMBER OF MATCHES",
                "ENTER VALID NUMBER [0-999]",
                0,
                999);

        return numberOfMatches;
    }
}
