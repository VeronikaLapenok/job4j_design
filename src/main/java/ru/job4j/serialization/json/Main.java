package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JSONObject jsonStudent = new JSONObject("{\"name\":Ivan, \"surname\":Ivanov}");

        List<String> subjectList = new ArrayList<>();
        subjectList.add("Math");
        subjectList.add("English");
        JSONArray jsonSubjects = new JSONArray(subjectList);

        final Group group = new Group("P-41", 13, true,
                new Student("Ivan", "Ivanov"), new String[] {"Math", "English"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", group.getName());
        jsonObject.put("numOfStudents", group.getNumOfStudents());
        jsonObject.put("isStudy", group.isStudy());
        jsonObject.put("student", jsonStudent);
        jsonObject.put("subjects", jsonSubjects);

        System.out.println(jsonObject);
        System.out.println(new JSONObject(group));
    }
}
