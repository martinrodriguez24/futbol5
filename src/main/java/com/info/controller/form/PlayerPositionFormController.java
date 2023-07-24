package com.info.controller.form;

import java.util.List;

import com.info.domain.Player.Position;
import com.info.service.PositionService;
import com.info.service.implement.PositionServiceImpl;
import com.info.util.InputValidatorUtil;

public class PlayerPositionFormController {
    PositionService positionService = new PositionServiceImpl();
    InputValidatorUtil validator = new InputValidatorUtil();
    List<Position> positions = positionService.getPositions();

    public Position playerPosition() {
        getPostions();

        int selectedPosition = validator.validateInt(
                "SELECT POSITION",
                "INVALID POSITION",
                1,
                4);

        Position position = positions.get(selectedPosition - 1);

        return position;
    }

    private void getPostions() {
        for (Position position : positions) {
            int index = positions.indexOf(position) + 1;
            System.out.println("[" + index + "]" + position.getName());
        }
    }
}
