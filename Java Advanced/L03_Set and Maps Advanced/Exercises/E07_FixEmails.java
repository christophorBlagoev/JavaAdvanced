package Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E07_FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//regex: .[us|com|uk]+$
        Map<String, String> namesAndEmails = new LinkedHashMap<>();

        String line = "";

        while (!"stop".equals(line = scanner.nextLine())){
            String name = line;
            String eMail = scanner.nextLine();
            String regex = ".[us|com|uk]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(eMail);

            if (!matcher.find()){
                namesAndEmails.putIfAbsent(name, eMail);
            }
        }
        namesAndEmails.forEach((k,v) -> System.out.println(String.format("%s -> %s", k, v)));
    }
}
