package com.info.utils;

import com.info.controllers.CoachController;
import com.info.controllers.PlayerController;
import com.info.controllers.TeamController;

public class ControllerInitUtil {
    private static ControllerInitUtil instance;
    private PlayerController playerController;
    private TeamController teamController;
    private CoachController coachController;

    private ControllerInitUtil() {
        playerController = new PlayerController();
        coachController = new CoachController();
        teamController = new TeamController(playerController, coachController);
    }

    public static ControllerInitUtil getInstance() {
        if (instance == null) {
            synchronized (ControllerInitUtil.class) {
                if (instance == null) {
                    instance = new ControllerInitUtil();
                }
            }
        }
        return instance;
    }

    public TeamController getTeamController() {
        return teamController;
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public CoachController getCoachController() {
        return coachController;
    }
}
