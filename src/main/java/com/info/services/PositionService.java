package com.info.services;

import java.util.ArrayList;
import java.util.List;

import com.info.models.Player.Position;

public class PositionService {
    private List<Position> positions;

    public PositionService() {
        positions = new ArrayList<>();
        positions.add(new Position("FORWARD"));
        positions.add(new Position("MIDFIELDER"));
        positions.add(new Position("DEFENDER"));
        positions.add(new Position("KEEPER"));
    }

    public List<Position> getAllPositions() {
        return positions;
    }
}