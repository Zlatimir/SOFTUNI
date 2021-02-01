import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 1.2.2021 г..
 */

public class Lootbox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //first box - queue
        //second box - stack

        Deque<Integer> firstBoxQueue = new ArrayDeque<>();
        Deque<Integer> secondBoxStack = new ArrayDeque<>();

        int[] array = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < array.length; i++) {
            firstBoxQueue.offer(array[i]);
        }

        array = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < array.length; i++) {
            secondBoxStack.push(array[i]);
        }

        int sum = 0;

        while(!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()){

            int firstBoxItem = firstBoxQueue.peek();
            int secondBoxItem = secondBoxStack.peek();

            if ((firstBoxItem + secondBoxItem) % 2 == 0){
                sum += firstBoxItem + secondBoxItem;
                firstBoxQueue.poll();
                secondBoxStack.pop();
            } else {
                secondBoxStack.pop();
                firstBoxQueue.offer(secondBoxItem);
            }



        }

        if (firstBoxQueue.isEmpty()){
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (sum >= 100){
            System.out.println("Your loot was epic! Value: " + sum);
        } else {
            System.out.println("Your loot was poor... Value: " + sum);
        }
    }
}
