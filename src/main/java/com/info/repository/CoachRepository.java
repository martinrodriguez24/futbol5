package com.info.repository;

import java.io.IOException;
import java.util.List;

import com.info.domain.Coach.Coach;

public interface CoachRepository {
    public void saveCoaches(List<Coach> coaches) throws IOException;
    
    public List<String[]> loadCoaches() throws IOException;
}
