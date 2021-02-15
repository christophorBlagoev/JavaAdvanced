package Exercises.P04_Froggy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Lake lake = new Lake(Arrays.stream(scanner.nextLine().trim().split(", ")).mapToInt(Integer::parseInt).toArray());
        Iterator< Integer > iterator = lake.iterator();
        while (iterator.hasNext()) {
            String current = iterator.next().toString();
            System.out.print(iterator.hasNext() ? String.format("%s, ", current) : current);
        }
    }
}
