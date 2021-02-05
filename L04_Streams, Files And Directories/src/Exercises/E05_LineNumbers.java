package L04_StreamsFilesAndDirectories;

import java.io.*;

public class E05_LineNumbers {
    private  static final String INPUT_PATH = "C:\\Users\\Forio\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
    private static final String OUTPUT_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
        PrintWriter writer = new PrintWriter(OUTPUT_PATH);

        String line = reader.readLine();
        int number = 1;

        while (line != null){
            writer.println(String.format("%d. %s", number, line));
            number++;
            line = reader.readLine();
        }

        writer.close();
    }
}
