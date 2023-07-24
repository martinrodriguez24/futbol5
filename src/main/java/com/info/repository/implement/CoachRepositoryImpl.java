package com.info.repository.implement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.info.domain.Coach.Coach;
import com.info.repository.CoachRepository;
import com.info.util.FileReaderUtil;
import com.info.util.FileWriterUtil;

public class CoachRepositoryImpl implements CoachRepository {
    private FileReaderUtil reader = new FileReaderUtil();
    private FileWriterUtil writer = new FileWriterUtil();
    private String coachTable = "src/main/java/com/info/resources/data/coach.csv";

    @Override
    public List<String[]> loadCoaches() throws IOException {
        List<String[]> coachData = reader.read(coachTable);
        return coachData;
    }

    private String saveCoach(Coach coach) {
        String line = coach.getName() + "," +
                    coach.getAge();
        return line;
    }

    @Override
    public void saveCoaches(List<Coach> coaches) throws IOException {
        List<String> columns = new ArrayList<>();

        for (Coach coach : coaches) {
            String line = saveCoach(coach);
            columns.add(line);
        }
        writer.writeFile(columns, coachTable);
    }
    

}