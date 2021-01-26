package L04_StreamsFilesAndDirectories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class E02_SumBytes {
    private  static final String Path = "C:\\Users\\Forio\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(Path));

        String line = reader.readLine();

        int sum = 0;
        while (line != null){
            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }

            line = reader.readLine();
        }
        System.out.println(sum);
    }
}
