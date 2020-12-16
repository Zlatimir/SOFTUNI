import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 16.12.2020 г..
 */

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '('){
                stack.push(i);
            } else {
                if (expression.charAt(i) == ')'){
                    System.out.println(expression.substring(stack.pop(), i + 1));
                }
            }
        }
    }
}
