package com.github.marcellodesales.advanced.trywithresources;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * The try-with-resources will be smaller because the classes in the try implements java.lang.AutoCloseable()
 * - var can be used if the compiler can identify
 * - try(in) can be used
 */
public class RemoveSpacesFromFileWith {

    public static void remove(String fileNameFrom, String saveFileName) throws IOException {
        // Resources will be closed by the finally properly
        try (var in = new BufferedReader(new FileReader(fileNameFrom, StandardCharsets.UTF_8));
             var out = new BufferedWriter(new FileWriter(saveFileName, StandardCharsets.UTF_8))) {

            String line;
            while((line = in.readLine()) != null) {
                if (!line.isEmpty()) {
                    out.write(line);
                    out.write(System.lineSeparator());
                }
            }
        }
    }
}
