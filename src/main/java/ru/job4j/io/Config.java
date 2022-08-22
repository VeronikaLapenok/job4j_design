package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private final HashMap<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            List<String> lines = read.lines().filter(line -> !line.contains("#") && !line.isEmpty())
                    .map(str -> str.trim())
                    .collect(Collectors.toList());
            for (String str : lines) {
                if (!Pattern.matches(".+=.+", str)) {
                    throw new IllegalArgumentException("Illegal pattern key-value");
                } else {
                    int splitIndex = str.indexOf('=');
                    values.put(str.substring(0, splitIndex), str.substring(splitIndex + 1));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}
