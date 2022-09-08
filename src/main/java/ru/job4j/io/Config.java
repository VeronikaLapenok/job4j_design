package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class Config {
    private final String path;
    private final HashMap<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().filter(str -> !str.contains("#") && !str.isEmpty())
                    .map(String::trim).forEach(str -> {
                        if (!Pattern.matches(".+=.+", str)) {
                            throw new IllegalArgumentException(
                                    String.format("Illegal pattern key-value: \"%s\"", str));
                        }
                        int splitIndex = str.indexOf("=");
                        values.put(str.substring(0, splitIndex), str.substring(splitIndex + 1));
                    });
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
        System.out.println(new Config("./data/app.properties"));
    }
}
