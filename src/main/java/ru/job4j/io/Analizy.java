package ru.job4j.io;

import java.io.*;

public class Analizy {
    private boolean isAvailable = true;
    
    public void unavailable(String source, String target) {
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {
            reader.lines().forEach(str -> {
                if ((str.startsWith("400") || str.startsWith("500")) && isAvailable) {
                    writer.print(str.substring(4) + ";");
                    isAvailable = false;
                } else if (str.startsWith("200") && !isAvailable) {
                    writer.print(str.substring(4) + ";" + System.lineSeparator());
                    isAvailable = true;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Analizy().unavailable("./data/server.log", "./data/target.log");
    }
}
