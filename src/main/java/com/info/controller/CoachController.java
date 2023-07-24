package com.info.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.info.controller.form.CoachFormController;
import com.info.domain.Coach.Coach;
import com.info.repository.CoachRepository;
import com.info.repository.implement.CoachRepositoryImpl;
import com.info.service.CoachService;
import com.info.service.implement.CoachServiceImpl;

public class CoachController {
    private CoachService coachService = new CoachServiceImpl();
    private CoachFormController form = new CoachFormController();
    private CoachRepository coachRepository = new CoachRepositoryImpl();

    private Coach createCoach(Coach coach) {
        return coachService.createCoach(coach);
    }

    public Coach createCoachByForm() {
        Coach coach = form.createCoachByForm();
        return createCoach(coach);
    }

    public String getCoach(Coach coach) {
        String data;
        if (coach != null) {
            data = "COACH\n" +
                    "Coach name: " + coach.getName() +
                    "\n" +
                    "Coach age: " + coach.getAge();

            return data;
        }
        data = "coach not exist";
        return data;
    }

    public void saveCoaches(List<Coach> coaches) throws IOException {
        coachRepository.saveCoaches(coaches);
    }

    public List<Coach> loadCoaches() throws IOException {
        List<String[]> coachesData = coachRepository.loadCoaches();
        List<Coach> coaches = new ArrayList<>();

        for (String row[] : coachesData) {

            String name = row[0];
            int age = Integer.parseInt(row[1]);

            Coach coach = new Coach(name, age);
            coaches.add(coach);
        }

        return coaches;
    }

}
