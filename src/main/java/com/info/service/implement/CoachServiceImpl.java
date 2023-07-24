package com.info.service.implement;

import java.util.ArrayList;
import java.util.List;

import com.info.domain.Coach.Coach;
import com.info.service.CoachService;

public class CoachServiceImpl implements CoachService {
    public List<Coach> coaches = new ArrayList<>();

    @Override
    public Coach createCoach(Coach coach) {
        
        return coach;
    }

    @Override
    public List<Coach> getCoaches() {
        return coaches;
    }

    @Override
    public Coach findCoachByName(String name) {
        for (Coach coach : coaches) {
            if (coach.getName().equals(name)) {
                return coach;
            }
        }
        return null;
    }
}
