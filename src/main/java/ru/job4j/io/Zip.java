package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(target.toFile())
        ))) {
            for (Path src : sources) {
                zip.putNextEntry(new ZipEntry(src.toFile().getPath()));
                try (BufferedInputStream in = new BufferedInputStream(
                        new FileInputStream(src.toFile()))) {
                    zip.write(in.readAllBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void validate(ArgsName zipArgs) {
        Path path = Paths.get(zipArgs.get("d"));
        String zip = zipArgs.get("o");
        String zipExtension = zip.substring(zip.indexOf("."));

        if (!Files.exists(path)) {
            throw new IllegalArgumentException(String.format(
                    "Not exist %s", path.toFile().getAbsoluteFile()));
        }

        if (!zipExtension.equals(".zip")) {
            throw new IllegalArgumentException(String.format(
                    "Is not a zip extension - %s", zip));
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException("Three arguments are expected");
        }
        Zip zip = new Zip();
        ArgsName zipArgs = ArgsName.of(args);
        validate(zipArgs);
        List<Path> source = Search.search(Paths.get(zipArgs.get("d")),
                f -> !f.toFile().getName().endsWith(zipArgs.get("e")));
        zip.packFiles(source, Path.of(zipArgs.get("o")));
    }
}
