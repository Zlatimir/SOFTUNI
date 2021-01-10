import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

/**
 * Created by Zlatimir Ivanov on 10.1.2021 г..
 */

public class AddVAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        UnaryOperator<Double> addVAT = x -> x * 1.2;

        double[] price = Arrays.stream(sc.nextLine().split(", ")).mapToDouble(Double::parseDouble).toArray();

        System.out.println("Prices with VAT:");

        for (double p : price) {
            System.out.printf("%.2f%n", addVAT.apply(p));
        }
    }
}
