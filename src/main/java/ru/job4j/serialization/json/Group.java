package ru.job4j.serialization.json;

import java.util.Arrays;

public class Group {
    private final String name;
    private final int numOfStudents;
    private final boolean isStudy;
    private final Student student;
    private final String[] subjects;

    public Group(String name, int numOfStudents, boolean isStudy,
                 Student student, String[] subjects) {
        this.name = name;
        this.numOfStudents = numOfStudents;
        this.isStudy = isStudy;
        this.student = student;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }

    public boolean isStudy() {
        return isStudy;
    }

    public Student getStudent() {
        return student;
    }

    public String[] getSubjects() {
        return subjects;
    }

    @Override
    public String toString() {
        return "Group{"
                + "name='" + name + '\''
                + ", numOfStudents=" + numOfStudents
                + ", isStudy=" + isStudy
                + ", student=" + student
                + ", subjects=" + Arrays.toString(subjects)
                + '}';
    }
}
