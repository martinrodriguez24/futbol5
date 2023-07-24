package com.info.controller.form;

import java.util.UUID;

import com.info.domain.Player.PlayerDataSheet;
import com.info.domain.Player.Position;
import com.info.util.InputValidatorUtil;

public class PlayerDataSheetFormController {
    private InputValidatorUtil validator = new InputValidatorUtil();
    PlayerPositionFormController positionForm = new PlayerPositionFormController();

    public PlayerDataSheet createPlayerDataSheetByForm () {
        int height = playerHeight();
        int numberOfShirt = playerNumberOfShirt();
        Position position = playerPosition();

        PlayerDataSheet playerDataSheet = new PlayerDataSheet(UUID.randomUUID(), height, numberOfShirt, position);

        return playerDataSheet;
    }

    private int playerHeight() {
        int height = validator.validateInt(
                "PLAYER HEIGHT [CM]",
                "ENTER VALID HEIGHT [130-250]CM",
                130,
                250);

        return height;
    }

    private int playerNumberOfShirt() {
        int numberOfShirt = validator.validateInt(
                "PLAYER NUMBER OF SHIRT [1-11]",
                "ENTER VALID NUMBER [1-11]",
                1,
                11);

        return numberOfShirt;
    }

    private Position playerPosition() {
        return positionForm.playerPosition();
    }
}
