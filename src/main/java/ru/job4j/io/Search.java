package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        validate(args);
        Path start = Paths.get(args[0]);
        search(start, p -> p.toFile().getName().endsWith(args[1])).
                forEach(System.out::println);
    }

    public static void validate(String[] args) throws IOException {
        if (args.length != 2) {
            throw new IllegalArgumentException("Two arguments are expected");
        }

        Path path = Paths.get(args[0]);

        if (!Files.exists(path)) {
            throw new IllegalArgumentException(String.format(
                    "Not exist %s", path.toFile().getAbsoluteFile()));
        }

        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException(String.format(
                    "Is not a file extencion - %s", args[1]));
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
