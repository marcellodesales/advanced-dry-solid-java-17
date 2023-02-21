package com.github.marcellodesales.advanced.trywithresources;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class TempDirectory implements AutoCloseable {

    private final Path directory;

    public TempDirectory(String prefix) throws IOException {
        this.directory = Files.createTempDirectory(prefix);
    }

    public Path getDirectory() {
        return directory;
    }

    @Override
    public void close() throws IOException {
        Files.walkFileTree(directory, new SimpleFileVisitor<>() {

            /**
             * @param file
             * @param attributes
             * @return The continuation after the file has been visited (deleted)
             * @throws IOException
             */
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            };

            /**
             * @param dir
             * @param possibleError
             * @return When the files and subdirectories have all been removed.
             * @throws IOException
             */
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException possibleError) throws IOException {
                if (possibleError == null) {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                } else {
                    throw possibleError;
                }
            };
         });
    }

    //Temporary dir: /var/folders/92/0vdzjmh11sxff2ms8wv1_9f00000gn/T/test5077456579860586061
    //File was created at /var/folders/92/0vdzjmh11sxff2ms8wv1_9f00000gn/T/test5077456579860586061/test.txt
    //It will be deleted as soon as the try block exits
    //Verify if the path exists: /var/folders/92/0vdzjmh11sxff2ms8wv1_9f00000gn/T/test5077456579860586061/test.txt
    //File indeed was deleted: /var/folders/92/0vdzjmh11sxff2ms8wv1_9f00000gn/T/test5077456579860586061/test.txt
    public static void main(String[] args) throws IOException {
        Path fileCreated = null;
        try (var tempDir = new TempDirectory("test");
            var out = Files.newBufferedWriter(tempDir.getDirectory().resolve("test.txt"), StandardCharsets.UTF_8)) {
            System.out.println("Temporary dir: " + tempDir.getDirectory());
            out.write("Contents to the temp file...");
            fileCreated = tempDir.getDirectory().resolve("test.txt");
            if (Files.exists(fileCreated)) {
                System.out.println("File was created at " + fileCreated);
                System.out.println("It will be deleted as soon as the try block exits");
            }
        }
        System.out.println("Verify if the path exists: " + fileCreated);
        if (!Files.exists(fileCreated)) {
            System.out.println("File indeed was deleted: " + fileCreated);
        }
    }
}
