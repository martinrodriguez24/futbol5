package com.info.domain.Player;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlayerDataSheet {
    private UUID id;
    private int height;
    private int numberOfShirt;
    private Position position;
}
