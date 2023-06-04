package com.info.controllers;

import java.util.List;

import com.info.models.Player.Position;
import com.info.services.PositionService;
import com.info.utils.InputValidatorUtil;

public class PositionController {
    PositionService positionService = new PositionService();
    InputValidatorUtil validator = new InputValidatorUtil();
    List<Position> positions = positionService.getAllPositions();

    public Position selectPosition() {
        String txt, alertTxt;
        int min, max;
        printPostions();

        txt = "select a POSITION";
        alertTxt = "invalid POSITION choice, should be int [1 - 4]";
        min = 1; max = 4;
        Position selectedPosition = positions.get(validator.validateInt(txt, alertTxt, min, max) - 1);

        return selectedPosition;
    }

    private void printPostions() {
        for (int i = 0; i < positions.size(); i++) {
            System.out.println("[ " + (i + 1)+ " ] :: " + positions.get(i).getName());
        }
    }
}
