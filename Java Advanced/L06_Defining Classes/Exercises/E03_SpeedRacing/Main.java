package Exercises.E03_SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

import static Exercises.E03_SpeedRacing.Car.drivingCar;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carInfo = new LinkedHashMap<>();

        IntStream.range(0, n)
                .mapToObj(i -> scanner.nextLine().split("\\s+"))
                .forEach(input -> {
                    String model = input[0];
                    double fuelAmount = Double.parseDouble(input[1]);
                    double fuelPricePerKilometer = Double.parseDouble(input[2]);
                    Car data = new Car(model, fuelAmount, fuelPricePerKilometer, 0);
                    carInfo.put(model, data);
                });

        String input = "";
        while (!"End".equals(input = scanner.nextLine())) {
            String[] tokens = input.split("\\s+");
            drivingCar(carInfo.get(tokens[1]), Integer.parseInt(tokens[2]));
        }

        carInfo.forEach((k, v) -> System.out.printf("%s %.2f %d%n", k, v.getFuelAmount(), v.getTraveledDistance()));
    }
}
