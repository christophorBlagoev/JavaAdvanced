package E2020_10_25;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01_Scheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque< Integer > taskStack = new ArrayDeque<>();
        ArrayDeque< Integer > threadQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(taskStack::push);
        Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).forEach(threadQueue::push);

        int targetTask = Integer.parseInt(scanner.nextLine());

        while (true) {
            int currentTask = taskStack.peek();
            int currentThread = threadQueue.peek();

            if (currentTask == targetTask) {
                System.out.printf("Thread with value %d killed task %d%n", currentThread, currentTask);
                printThreads(threadQueue);
                return;
            } else if (currentThread >= currentTask) {
                taskStack.pop();
                threadQueue.poll();
            } else {
                threadQueue.poll();
            }
        }
    }

    private static void printThreads(ArrayDeque< Integer> threadQueue) {
        StringBuilder output = new StringBuilder();
        while (!threadQueue.isEmpty()) {
            output.append(threadQueue.poll()).append(" ");
        }
        System.out.println(output.toString().trim());
    }
}
