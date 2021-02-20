import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 20.2.2021 г..
 */

public class Exam_Problem_01_MagicBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> firstBoxQueue = new ArrayDeque<>();
        Deque<Integer> secondBoxStack = new ArrayDeque<>();

        int[] ints = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int number : ints) {
            firstBoxQueue.offer(number);
        }

        ints = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int number : ints) {
            secondBoxStack.push(number);
        }

        int sum = 0;

        while (!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()){
            int first = firstBoxQueue.peek();
            int second = secondBoxStack.peek();

            if ((first + second) % 2 == 0){
                sum += first + second;
                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                secondBoxStack.pop();
                firstBoxQueue.offer(second);
            }
        }

        if (firstBoxQueue.isEmpty()){
            System.out.println("First magic box is empty.");
        }

        if (secondBoxStack.isEmpty()){
            System.out.println("Second magic box is empty.");
        }

        if (sum >= 90){
            System.out.println("Wow, your prey was epic! Value: " + sum);
        } else {
            System.out.println("Poor prey... Value: " + sum);
        }
    }
}
