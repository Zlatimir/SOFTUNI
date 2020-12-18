import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 18.12.2020 г..
 */

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String command = input[0];
            switch (command){
                case "1":
                    int x = Integer.parseInt(input[1]);
                    stack.push(x);
                    break;
                case "2":
                    if (!stack.isEmpty()) stack.pop();
                    break;
                case "3":
                    if (!stack.isEmpty()){
                        System.out.println(Collections.max(stack));
                    }
                    break;
            }
        }
    }
}
