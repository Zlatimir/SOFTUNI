import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 20.9.2020 г..
 */

public class SumOfChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            sum = sum + s.charAt(0);
        }
        System.out.printf("The sum equals: %d", sum);
    }
}
