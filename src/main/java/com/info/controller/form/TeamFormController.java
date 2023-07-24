package com.info.controller.form;

import java.time.LocalDateTime;
import java.util.List;

import com.info.controller.CoachController;
import com.info.controller.PlayerController;
import com.info.domain.Player.Player;
import com.info.domain.Team;
import com.info.domain.Coach.Coach;

import com.info.util.InputValidatorUtil;

public class TeamFormController {
    private InputValidatorUtil validator = new InputValidatorUtil();
    private PlayerController playerController = new PlayerController();
    private CoachController coachController = new CoachController();

    public Team createTeamByForm() {
        System.out.println("CREATING TEAM");

        String name = name();
        LocalDateTime createdAt = LocalDateTime.now();
        List<Player> players = playerController.createPlayersByForm();
        Coach coach = coachController.createCoachByForm();

        Team team = new Team(name, players, coach, createdAt);
        return team;
    }    

    public String name() {
        String name = validator.validateString(
                "ENTER TEAM NAME",
                "ENTER A VALID NAME",
                2,
                255);
        return name;
    }
}
