import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 21.2.2021 г..
 */

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        printTop(n);

        printBottom(n);
    }

    private static void printTop(int n) {
        for (int i = 1; i <= n; i++) {
            printRow(i, n);
            System.out.println();
        }
    }

    private static void printBottom(int n){
        for (int i = n -1; i >= 0 ; i--) {
            printRow(i, n);
            System.out.println();
        }
    }

    private static void printRow(int i, int n) {
        for (int j = n - i - 1; j >= 0 ; j--) {
            System.out.print(" ");
        }

        for (int j = 1; j < i + 1; j++) {
            System.out.print("* ");
        }
    }
}
