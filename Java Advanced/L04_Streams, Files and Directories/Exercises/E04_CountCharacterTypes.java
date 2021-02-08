package Exercises;

import java.io.*;
import java.util.Set;

public class E04_CountCharacterTypes {
    private  static final String INPUT_PATH = "C:\\Users\\Forio\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
    private static final String OUTPUT_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(INPUT_PATH));
        PrintWriter writer = new PrintWriter(OUTPUT_PATH);

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of('!', ',','.', '?');
        int vowelsCount = 0;
        int consonantCount = 0;
        int punctuationCount = 0;

        String line = reader.readLine();

        while (line != null){
            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                if (vowels.contains(symbol)){
                    vowelsCount++;
                } else if (punctuation.contains(symbol)){
                    punctuationCount++;
                } else if (symbol != ' '){
                    consonantCount++;
                }
            }

            line = reader.readLine();
        }

        writer.println("Vowels: " + vowelsCount);
        writer.println("Consonants: " + consonantCount);
        writer.println("Punctuation: " + punctuationCount);
        writer.close();
    }
}
