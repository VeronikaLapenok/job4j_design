package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class ResultFile {
    public static int[][] multiple(int size) {
        int[][] array = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int cell = 0; cell < size; cell++) {
                array[row][cell] = (row + 1) * (cell + 1);
            }
        }
        return array;
    }

    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("./data/result.txt")) {
            int size = 5;
            int[][] array = multiple(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    out.write(String.valueOf(array[i][j]).getBytes());
                    out.write(" ".getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
