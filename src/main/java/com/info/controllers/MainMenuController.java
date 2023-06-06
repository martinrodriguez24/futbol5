package com.info.controllers;

import java.io.IOException;

import com.info.utils.ControllerInitUtil;
import com.info.utils.InputValidatorUtil;

public class MainMenuController {
    private boolean continueProgram;
    private InputValidatorUtil validator;
    private ControllerInitUtil initializator = ControllerInitUtil.getInstance();
    PlayerController playerController = initializator.getPlayerController();
    CoachController coachController = initializator.getCoachController();
    TeamController teamController = initializator.getTeamController();

    LoadTeamsController loadData = new LoadTeamsController();
    SaveTeamsController saveData = new SaveTeamsController();

    public MainMenuController() {
        this.validator = new InputValidatorUtil();
        this.continueProgram = true;
    }

    public void main() throws IOException {
        loadData.LoadTeamFromTable();
        String menu = "\nselect choice\n" +
                "|  [1] :: create team  |\n" +
                "|  [2] :: list teams   |\n" +
                "|  [3] :: search team  |\n" +
                "|  [4] :: remove team  |\n" +
                "|  [5] :: save ALL     |\n" +
                "|  [6] :: EXIT         |\n",
                txt, alertTxt;
        while (continueProgram) {
            System.out.println(menu);

            txt = "INSERT INPUT";
            alertTxt = "ERR, TRY AGAIN";
            int choice = validator.validateInt(txt, alertTxt, 0, 10);

            selectChoice(choice);
        }
    }

    private void selectChoice(int choice) throws IOException {
        switch (choice) {
            case 1:
                teamController.CreateTeam();
                break;
            case 2:
                teamController.PrintAllTeams();
                break;
            case 3:
                teamController.searchTeamAndPrint();
                break;
            case 4:
                teamController.removeTeamByName();
                break;
            case 5:
                saveData.saveAllTeams();
                break;
            case 6:
                this.continueProgram = false;
                break;
            default:
                break;
        }
    }
}
