package L01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        int offerElements = Integer.parseInt(tokens[0]);
        int pollElements = Integer.parseInt(tokens[1]);
        int number = Integer.parseInt(tokens[2]);

        String[] queueAsString = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> queue= new ArrayDeque<>();

        for (int i = 0; i < offerElements; i++) {
            queue.offer(Integer.parseInt(queueAsString[i]));
        }

        for (int i = 0; i < pollElements; i++) {
            queue.poll();
        }

        if (!queue.isEmpty()) {
            if (queue.contains(number)) {
                System.out.println("true");
            } else {
                int minNumber = Integer.MAX_VALUE;
                for (Integer integer : queue) {
                    if (integer < minNumber) {
                        minNumber = integer;
                    }
                }
                System.out.println(minNumber);
            }
        } else {
            System.out.println("0");
        }
    }
}
