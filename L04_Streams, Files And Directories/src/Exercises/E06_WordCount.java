package L04_StreamsFilesAndDirectories;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class E06_WordCount {
    private  static final String WORDS_INPUT_PATH = "C:\\Users\\Forio\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
    private  static final String TEXT_INPUT_PATH = "C:\\Users\\Forio\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
    private static final String OUTPUT_PATH = "output.txt";

    public static void main(String[] args) throws IOException {
        BufferedReader wordReader = new BufferedReader(new FileReader(WORDS_INPUT_PATH));
        BufferedReader textReader = new BufferedReader(new FileReader(TEXT_INPUT_PATH));
        PrintWriter writer = new PrintWriter(OUTPUT_PATH);

        String[] words = wordReader.readLine().split("\\s+");
        Map<String, Integer> wordOccurrences = new HashMap<>();
        for (String word : words) {
            wordOccurrences.put(word, 0);
        }

        String[] text = textReader.readLine().split("\\s+");
        for (String word : text) {
            if (wordOccurrences.containsKey(word)){
                wordOccurrences.put(word, wordOccurrences.get(word) + 1);
            }

        }

        wordOccurrences.entrySet()
                .stream()
                .sorted((w1, w2) -> w2.getValue().compareTo(w1.getValue()))
                .forEach(w -> writer.println(String.format("%s - %d", w.getKey(), w.getValue())));

        writer.close();
    }
}
