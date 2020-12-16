import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 16.12.2020 г..
 */

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decimalNumber = Integer.parseInt(sc.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if (decimalNumber == 0){
            System.out.println(0);
        } else {
            while (decimalNumber > 0){
                stack.push(decimalNumber % 2);
                decimalNumber /= 2;
            }
            while (!stack.isEmpty()){
                System.out.print(stack.pop());
            }
        }
    }
}
