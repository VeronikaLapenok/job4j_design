package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    private boolean isAvailable = true;
    
    public void unavailable(String source, String target) {
        List<String> targetList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            reader.lines().forEach(str -> {
                if ((str.startsWith("400") || str.startsWith("500")) && isAvailable) {
                    targetList.add(str.substring(4) + ";");
                    isAvailable = false;
                } else if (str.startsWith("200") && !isAvailable) {
                    targetList.add(str.substring(4) + ";" + System.lineSeparator());
                    isAvailable = true;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(target))) {
            targetList.forEach(writer::print);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Analizy().unavailable("./data/server.log", "./data/target.log");
    }
}
