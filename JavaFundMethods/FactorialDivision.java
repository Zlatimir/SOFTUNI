package JavaFundMethods;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 1.10.2020 г..
 */

public class FactorialDivision {

    private static double factorial(double n) {
        double factorial = 1;
        for (int i = 2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        BigDecimal result = new BigDecimal(factorial(a) / factorial(b));
        System.out.printf("%.2f", result);
    }
}
