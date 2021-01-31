package L01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        int cycle = 1;

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : children) {
            queue.offer(child);
        }

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String child = queue.poll();
                queue.offer(child);
            }

            String name = queue.peek();
            if (!isPrime(cycle)) {
                System.out.println("Removed " + name);
                queue.remove();
            } else {
                System.out.println("Prime " + name);
            }

            cycle++;
        }

        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
