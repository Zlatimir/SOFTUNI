import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 18.12.2020 г..
 */

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] input = sc.nextLine().split("\\s+");
        for (int i = 0; i < input.length; i++) {
            int number = Integer.parseInt(input[i]);
            stack.push(number);
        }

        while(stack.size()>1){
            System.out.print(stack.pop() + " ");
        }
        System.out.println(stack.pop());
    }
}
