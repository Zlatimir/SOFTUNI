import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 16.12.2020 г..
 */

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] tokens = line.split("\\s+");
        Collections.addAll(stack, tokens);

        while (stack.size() > 1){
            int first = Integer.parseInt(stack.pop());
            String operand = stack.pop();
            int second = Integer.parseInt(stack.pop());
            switch (operand){
                case "+":
                    stack.push(String.valueOf(first + second));
                    break;
                case "-":
                    stack.push(String.valueOf(first - second));
                    break;
            }
        }
        System.out.println(stack.peek());
    }
}
