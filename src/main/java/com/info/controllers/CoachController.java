package com.info.controllers;

import com.info.models.Coach;
import com.info.models.Team;
import com.info.utils.InputValidatorUtil;

public class CoachController {
    private InputValidatorUtil validator = new InputValidatorUtil();

    public void createCoach(Team team) {
        String txt, alertTxt;
        int min, max;
        Coach coach = new Coach();

        txt = "coach NAME";
        alertTxt = "invalid NAME, should be a name with only characters";
        min = 2;
        max = 255;

        coach.setName(validator.validateString(txt, alertTxt, min, max));

        txt = "coach SURNAME";
        alertTxt = "invalid SURNAME, should be a surname with only characters";

        coach.setSurname(validator.validateString(txt, alertTxt, min, max));

        txt = "coach AGE";
        alertTxt = "invalid AGE, should be a int [ 16 - 99 ]";
        min = 16;
        max = 99;

        coach.setAge(validator.validateInt(txt, alertTxt, min, max));

        team.setCoach(coach);
    }

    public void printCoachOfTeam(Coach coach) {
        System.out.println("***************************");
        String data = "Coach NAME: " + coach.getName() + " " + coach.getSurname() +
                "\nCoach AGE: " + coach.getAge();
        System.out.println(data);
    }
}
