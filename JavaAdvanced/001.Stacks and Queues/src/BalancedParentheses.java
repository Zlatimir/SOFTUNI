import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 18.12.2020 г..
 */

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayDeque<Character> brackets = new ArrayDeque<>();

        boolean balanced = true;
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                    brackets.push('}');
                    break;
                case '[':
                    brackets.push(']');
                    break;
                case '(':
                    brackets.push(')');
                    break;
                case '}':

                case ']':

                case ')':
                    if (brackets.isEmpty() || brackets.pop() != ch){
                        balanced = false;
                    }
                    break;

            }
            if (!balanced) break;
        }

        if (balanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
