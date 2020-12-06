import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 25.6.2020 г..
 */

public class ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        BigDecimal sum = new BigDecimal("0");
        for (int i = 0; i < n; i++) {
            BigDecimal a = new BigDecimal(sc.nextLine());
            sum = sum.add(a);
        }
        System.out.println(sum);

    }
}
