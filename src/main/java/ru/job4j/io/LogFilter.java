package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LogFilter {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            in.lines().filter(line -> line.contains(" 404 ")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
