package com.info.models.Player;

import java.util.UUID;

public class PlayerDataSheet {
    private UUID id;
    private int numberOfShirt;
    private Position position;
    
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public int getNumberOfShirt() {
        return numberOfShirt;
    }
    public void setNumberOfShirt(int numberOfShirt) {
        this.numberOfShirt = numberOfShirt;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    private int height;
}
