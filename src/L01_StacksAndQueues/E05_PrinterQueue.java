package L01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E05_PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String command;

        while (!"print".equals(command = scanner.nextLine())) {
            if (command.equals("cancel")) {
                String fileName = printerQueue.poll();
                if (fileName != null) {
                    System.out.println("Canceled " + fileName);
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printerQueue.offer(command);
            }
        }
        for (String fileName : printerQueue) {
            System.out.println(fileName);
        }

//        while (!printerQueue.isEmpty()) {
//            System.out.println(printerQueue.poll());
//        }
    }
}
