package com.info.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {
    public List<String[]> read(String filePath) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        List<String[]> data = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            String[] row = line.split(",");
            data.add(row);
        }
        reader.close();
        return data;
    }
}
