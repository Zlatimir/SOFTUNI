import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 25.6.2020 г..
 */

public class PoundsToDollars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double pound = Double.parseDouble(sc.nextLine());
        System.out.printf("%.3f", pound * 1.31);
    }
}
