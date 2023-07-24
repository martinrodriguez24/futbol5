package com.info.service;

import java.util.List;

import com.info.domain.Player.Position;

public interface PositionService {
    List<Position> getPositions();

    Position getPositionByName(String name);
}