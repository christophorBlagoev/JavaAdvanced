package Exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class E07_MergeTwoFiles {
    private  static final String INPUT_ONE_PATH = "C:\\Users\\Forio\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
    private  static final String INPUT_TWO_PATH = "C:\\Users\\Forio\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
    private static final String OUTPUT_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader readerInputOne = new BufferedReader(new FileReader(INPUT_ONE_PATH));
        BufferedReader readerInputTwo = new BufferedReader(new FileReader(INPUT_TWO_PATH));
        PrintWriter writer = new PrintWriter(OUTPUT_PATH);

        List<String> result = new ArrayList<>();
        String line = readerInputOne.readLine();

        while (line != null){
            writer.println(line);
            line = readerInputOne.readLine();
        }

        line = readerInputTwo.readLine();
        while (line != null){
            writer.println(line);
            line = readerInputTwo.readLine();
        }

        writer.close();
    }
}
