package Exercises;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class E08_GetFolderSize {
    private static final String DIR_PATH = "src/L04_StreamsFilesAndDirectories/Resource/Exercises Resources";
    private static final String OUTPUT_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter(OUTPUT_PATH);

        File folder = new File(DIR_PATH);
        int size = 0;
        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                size += file.length();
            }
        }

        writer.println("Folder size: " + size);
        writer.close();
    }
}
