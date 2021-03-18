import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstMagicBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(secondMagicBox::push);

        int sumItems = 0;

       while (!firstMagicBox.isEmpty() && !secondMagicBox.isEmpty()) {
           int sum = firstMagicBox.peek() + secondMagicBox.peek();

           if (sum % 2 == 0) {
               sumItems += sum;
               firstMagicBox.poll();
               secondMagicBox.pop();
           } else {
               firstMagicBox.offer(secondMagicBox.pop());
           }
       }
       if (firstMagicBox.isEmpty()) {
           System.out.println("First magic box is empty.");
       } else {
           System.out.println("Second magic box is empty.");
       }
       if (sumItems >= 90) {
           System.out.println("Wow, your prey was epic! Value: " + sumItems);
       } else {
           System.out.println("Poor prey... Value: " + sumItems);
       }
    }
}
