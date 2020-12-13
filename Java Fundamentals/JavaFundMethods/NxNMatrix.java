package JavaFundMethods;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 1.10.2020 г..
 */

public class NxNMatrix {

    private static void printLine(int n){
        for (int i = 0; i < n; i++) {
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            printLine(n);
            System.out.println();
        }
    }

}
