package Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class E03_ALLCAPITALS {
    private static final String INPUT_PATH = "C:\\Users\\Forio\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
    private static final String OUTPUT_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
        PrintWriter writer = new PrintWriter(OUTPUT_PATH);

        String line = reader.readLine();

        while (line != null) {
           writer.println(line.toUpperCase(Locale.ROOT));
            line = reader.readLine();
        }

        writer.close();
    }
}
