package com.info.service.implement;

import java.util.ArrayList;
import java.util.List;


import com.info.service.PositionService;
import com.info.domain.Player.Position;

public class PositionServiceImpl implements PositionService {
        private List<Position> positions;

        public PositionServiceImpl () {
            positions = new ArrayList<>();
            positions.add(new Position("FORWARD"));
            positions.add(new Position("DEFENDER"));
            positions.add(new Position("MIDFIELDER"));
            positions.add(new Position("GOALKEEPER"));
        }

        @Override
        public List<Position> getPositions() {
            return positions;
        }

        @Override
        public Position getPositionByName(String name) {
            for (Position position : positions) {
                if (position.getName().equals(name)) {
                    return position;
                }
            }
            return null;
        }
}
