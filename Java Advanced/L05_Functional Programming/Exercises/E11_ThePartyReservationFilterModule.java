package Exercises;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E11_ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guest = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Map<String, Predicate<String>> predicates = new HashMap<>();

        String line = "";
        while (!"Print".equals(line = scanner.nextLine())){
            String[] tokens = line.split(";");
            String predicateName = tokens[1] + tokens[2];

            if (tokens[0].contains("Add")){
                Predicate<String> predicate;
            } else {
                predicates.remove(predicateName);
            }
        }
    }
}
