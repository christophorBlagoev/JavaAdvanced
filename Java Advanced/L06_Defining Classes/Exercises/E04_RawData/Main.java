package Exercises.E04_RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carInfo = new ArrayList<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");

            Car data = new Car(input[0], Integer.parseInt(input[2]), input[4], Double.parseDouble(input[5])
            , Double.parseDouble(input[7]), Double.parseDouble(input[9]), Double.parseDouble(input[11]));

            carInfo.add(data);
        }

        String cargoType = scanner.nextLine();

        if (cargoType.equals("fragile")) {
            carInfo.stream()
                    .filter(e -> e.getCargoType().equals("fragile") && e.tirePressure())
                    .forEach(System.out::println);
        } else {
            carInfo.stream()
                    .filter(e -> e.getCargoType().equals("flamable") && e.getEnginePower() > 250)
                    .forEach(System.out::println);
        }
    }
}
