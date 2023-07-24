package com.info.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterUtil {
    private FileWriter fileWriter;

    public void writeFile(List<String> data, String filePath) throws IOException {
        this.fileWriter = new FileWriter(filePath);
        for (String line : data) {
            writeLine(line);
        }
        close();
    }

    public void writeLine(String line) throws IOException {
        fileWriter.write(line + "\n");
    }

    public void close() throws IOException {
        fileWriter.close();
    }
}
