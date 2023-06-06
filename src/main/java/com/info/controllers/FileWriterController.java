package com.info.controllers;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class FileWriterController {
    public void writeFile(String filePath, List<String> table) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(filePath);

        for (String row : table) {
            writer.println(row);
        }
        writer.close();
    }
}
