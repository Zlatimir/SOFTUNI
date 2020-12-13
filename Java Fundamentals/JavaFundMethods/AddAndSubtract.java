package JavaFundMethods;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 1.10.2020 г..
 */

public class AddAndSubtract {

    private static int sum(int a, int b){
        return a + b;
    }

    private static int subtract(int a, int b){
        return a - b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int plus = sum(a, b);
        System.out.println(subtract(plus, c));
    }
}
