import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 27.12.2020 г..
 */

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> roses = new ArrayDeque<>();
        ArrayDeque<Integer> lilies = new ArrayDeque<>();


        String[] input = sc.nextLine().split(", ");
        for (int i = 0; i < input.length; i++) {
            lilies.push(Integer.parseInt(input[i]));
        }

        input = sc.nextLine().split(", ");
        for (int i = 0; i < input.length; i++) {
            roses.offer(Integer.parseInt(input[i]));
        }


        int total = 0;
        int remaining = 0;

        while (roses.size() != 0 && lilies.size() != 0) {
            int rose = roses.peek();
            int lili = lilies.peek();
            int sum = rose + lili;
            if (sum == 15) {
                total++;
                roses.poll();
                lilies.pop();
            } else if (sum < 15){
                remaining += sum;
                roses.poll();
                lilies.pop();
            } else {
                lilies.pop();
                lili -= 2;
                lilies.push(lili);
            }
        }

        total += remaining / 15;

        if (total >= 5) {
            System.out.println("You made it, you are going to the competition with " + total + " wreaths!");
        } else {
            System.out.println("You didn't make it, you need " + (5 - total) + " wreaths more!");
        }

    }
}
