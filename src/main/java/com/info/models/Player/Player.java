package com.info.models.Player;

import com.info.models.Person;

public class Player extends Person {
    private PlayerDataSheet playerDataSheet;
    private PlayerStats playerStats;

    public Player() {
        this.playerDataSheet = new PlayerDataSheet();
        this.playerStats = new PlayerStats();
    }

    public PlayerDataSheet getPlayerDataSheet() {
        return playerDataSheet;
    }
    public void setPlayerDataSheet(PlayerDataSheet playerDataSheet) {
        this.playerDataSheet = playerDataSheet;
    }
    public PlayerStats getPlayerStats() {
        return playerStats;
    }
    public void setPlayerStats(PlayerStats playerStats) {
        this.playerStats = playerStats;
    }
    
}