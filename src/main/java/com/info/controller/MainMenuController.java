package com.info.controller;

import java.io.IOException;

import com.info.util.InputValidatorUtil;

public class MainMenuController {
    private boolean continueProgram;
    private InputValidatorUtil validator;
    TeamController teamController = new TeamController();

    public MainMenuController() {
        this.validator = new InputValidatorUtil();
        this.continueProgram = true;
    }

    public void main() throws IOException {
        teamController.loadTeams();
        String menu = "\nselect choice\n" +

                "|  [1] :: create team  |\n" +
                "|  [2] :: list teams   |\n" +
                "|  [3] :: save team    |\n" +
                "|  [4] :: remove team  |\n" +
                "|  [5] :: EXIT         |\n",
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
                System.out.println(teamController.createTeamByForm());
                teamController.saveTeams();
                break;
            case 2:
                teamController.printTeams();
                break;
            case 3:
                teamController.saveTeams();
                break;
            // case 4:
            // teamController.removeTeamByName();
            // break;
            case 5:
            this.continueProgram = false;

            default:
                break;
        }
    }
}
