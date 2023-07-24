package com.info.domain;

import java.time.LocalDateTime;
import java.util.List;

import com.info.domain.Coach.Coach;
import com.info.domain.Player.Player;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
public class Team {
    private String name;
    private List<Player> players;
    private Coach coach;
    private LocalDateTime createdAt;
}