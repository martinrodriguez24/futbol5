package com.info.controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderController {

    public List<String[]> readFile(String filePath) throws IOException {
        // String filePath = 

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