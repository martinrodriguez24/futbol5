package com.info.controllers;

import com.info.utils.ControllerInitUtil;
import com.info.utils.InputValidatorUtil;

public class MainMenuController {
    private boolean continueProgram;
    private InputValidatorUtil validator;
    private ControllerInitUtil initializator = ControllerInitUtil.getInstance();
    PlayerController playerController = initializator.getPlayerController();
    CoachController coachController = initializator.getCoachController();
    TeamController teamController = initializator.getTeamController();

    public MainMenuController() {
        this.validator = new InputValidatorUtil();
        this.continueProgram = true;
    }

    public void main() {
        String menu = "select choice",
                txt, alertTxt;
        while (continueProgram) {
            System.out.println(menu);

            txt = "INSERT INPUT";
            alertTxt = "ERR, TRY AGAIN";
            int choice = validator.validateInt(txt, alertTxt, 0, 10);

            selectChoice(choice);
        }
    }

    private void selectChoice(int choice) {
        switch (choice) {
            case 1:
                teamController.CreateTeam();
                break;
            case 2:
                teamController.PrintAllTeams();
                break;
            case 3:
                this.continueProgram = false;
                break;
            default:
                break;
        }
    }
}
