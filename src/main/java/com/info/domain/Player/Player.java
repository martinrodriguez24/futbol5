package com.info.domain.Player;

import com.info.domain.Person;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player extends Person {
    private PlayerDataSheet playerDataSheet;
    private PlayerStats playerStats;
    
    public Player(String name, PlayerDataSheet playerDataSheet, PlayerStats playerStats) {
        this.name = name;
        this.playerDataSheet = playerDataSheet;
        this.playerStats = playerStats;
    }

}