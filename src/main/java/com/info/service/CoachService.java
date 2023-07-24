package com.info.service;

import java.util.List;

import com.info.domain.Coach.Coach;

public interface CoachService {
    public Coach createCoach(Coach coach);

    public Coach findCoachByName(String name);

    public List<Coach> getCoaches();
}
