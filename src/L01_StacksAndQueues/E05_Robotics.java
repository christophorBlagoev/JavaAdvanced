package L01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E05_Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // input ROB-15;SS2-10;NX8000-3 (name-time;name-time;name-time)

        String[] input = scanner.nextLine().split(";");
        String[] namesOfRobots = new String[input.length];
        int[] processTime = new int[input.length];


        for (int i = 0; i < input.length; i++) {
            String[] tokens = input[i].split("-");
            namesOfRobots[i] = tokens[0];
            processTime[i] = Integer.parseInt(tokens[1]);
        }
        // input starting hour 08:00:00
        String[] startingTime = scanner.nextLine().split(":");
        int hours = Integer.parseInt(startingTime[0]);
        int minutes = Integer.parseInt(startingTime[1]);
        int seconds = Integer.parseInt(startingTime[2]);

        int startingTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        ArrayDeque<String> productLine = new ArrayDeque<>();

        String nextLine;
        while (!"End".equals(nextLine = scanner.nextLine())) {
            productLine.offer(nextLine);
        }
        int[] workTime = new int[input.length];

        while (!productLine.isEmpty()) {
            boolean isWorking = false;
            startingTimeInSeconds++;
            String product = productLine.poll();

            for (int i = 0; i < namesOfRobots.length; i++) {

                if (workTime[i] == 0 && !isWorking) {
                    workTime[i] = processTime[i];
                    isWorking = true;
                    robotData(namesOfRobots[i], product, startingTimeInSeconds);
                }
                if (workTime[i] > 0) {
                    workTime[i]--;
                }
            }
            if (!isWorking) {
                productLine.offer(product);
            }

        }

    }

    private static void robotData(String robotName, String product, int startingTime) {
        int hours = (startingTime / (60*60)) % 24;
        int minutes = (startingTime / 60) % 60;
        int seconds = startingTime % 60;
        String print = String.format("%s - %s [%02d:%02d:%02d]", robotName, product, hours, minutes, seconds);
        System.out.println(print);
    }
}
