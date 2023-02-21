package com.github.marcellodesales.advanced.trywithresources;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class RemoveSpacesFromFileWithout {

    public static void remove(String fileNameFrom, String saveFileName) throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;

        try {
            in = new BufferedReader(new FileReader(fileNameFrom, StandardCharsets.UTF_8));
            out = new BufferedWriter(new FileWriter(saveFileName, StandardCharsets.UTF_8));

            String line;
            while((line = in.readLine()) != null) {
                if (!line.isEmpty()) {
                    out.write(line);
                    out.write(System.lineSeparator());
                }
            }

        } finally {
            // close the resources if they are open (if the files existed)
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.err.println("Couldn't close in");
                }

            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.err.println("Couldn't close out");
                }
            }
        }
    }
}
