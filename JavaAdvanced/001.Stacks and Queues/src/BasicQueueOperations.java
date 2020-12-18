import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 18.12.2020 г..
 */

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] line = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(line[0]);
        int s = Integer.parseInt(line[1]);
        int x = Integer.parseInt(line[2]);
        line = sc.nextLine().split("\\s+");
        for (int i = 0; i < n; i++) {
            stack.offer(Integer.parseInt(line[i]));
        }

        if (s > n) {
            System.out.println(0);
        }
        for (int i = 0; i < s; i++) {
            if (!stack.isEmpty()) {
                stack.poll();
            } else {
                break;
            }
        }

        if (stack.contains(x)) {
            System.out.println("true");
        } else if (!stack.isEmpty()) {
            int min = Collections.min(stack);
            System.out.println(min);
        } else System.out.println(0);

    }
}
