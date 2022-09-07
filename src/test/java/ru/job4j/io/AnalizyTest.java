package ru.job4j.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class AnalizyTest {
    @Test
    void checkUnavailable(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("sourceTest.log").toFile();
        try (PrintWriter writer = new PrintWriter(source)) {
            writer.println("200 10:56:01");
            writer.println("500 10:57:01");
            writer.println("400 10:58:01");
            writer.println("200 10:59:01");
            writer.println("500 11:01:02");
        }
        File target = tempDir.resolve("targetTest.log").toFile();
        new Analizy().unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(result::append);
        }
        assertThat("10:57:01;10:59:01;11:01:02;").isEqualTo(result.toString());
    }

    @Test
    void checkIfAvailable(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("sourceTest.log").toFile();
        try (PrintWriter writer = new PrintWriter(source)) {
            writer.println("200 10:56:01");
            writer.println("200 10:59:01");
        }
        File target = tempDir.resolve("targetTest.log").toFile();
        new Analizy().unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(result::append);
        }
        Assertions.assertTrue(result.isEmpty());
    }
}
