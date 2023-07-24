package com.info.controller.form;

import com.info.domain.Coach.Coach;
import com.info.util.InputValidatorUtil;

public class CoachFormController {
    private InputValidatorUtil validator = new InputValidatorUtil();

    public Coach createCoachByForm () {
        System.out.println("CREATING NEW COACH");
        String name = coachName();
        int age = coachAge();
        Coach coach = new Coach(name, age);

        return coach;
    }

    private String coachName() {
        String name = validator.validateString(
                "NAME",
                "ENTER VALID NAME",
                2,
                255);
        return name;
    }

    private int coachAge() {
        int age = validator.validateInt(
                "ENTER AGE OF COACH",
                "INVALID AGE",
                10,
                100);

        return age;
    }
}
