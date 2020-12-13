package JavaFundMethods;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 1.10.2020 г..
 */

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(smallestNumber(a, b, c));

    }

    private static int smallestNumber(int a, int b, int c){
        if (a<=b && a<=c){
            return a;
        }
        if (b<=a && b<=c){
            return b;
        }
        if (c<=a && c<=b){
            return c;
        }
        return 999999999;
    }
}
