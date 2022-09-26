package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Group group = new Group("P-41", 13, true,
                new Student("Ivan", "Ivanov"), new String[] {"Math", "English"});

        final Gson gson = new GsonBuilder().create();
        System.out.println("Json string : " + gson.toJson(group));

        final String groupJson =
                "{"
                    + "\"name\":P-41,"
                    + "\"numOfStudents\":13,"
                    + "\"isStudy\":true,"
                    + "\"student\":"
                    + "{"
                    + "\"name\":Ivan,"
                    + "\"surname\":Ivanov"
                    + "},"
                    + "\"subjects\":"
                    + "[\"Math\",\"English\"]"
                    + "}";
        final Group groupMod = gson.fromJson(groupJson, Group.class);
        System.out.println(groupMod);
    }
}
