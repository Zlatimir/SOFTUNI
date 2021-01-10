import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Created by Zlatimir Ivanov on 10.1.2021 г..
 */

public class SumNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(", ");

        Function<String, Integer> parseInt = e -> Integer.parseInt(e);

        if (line.length < 2){
            System.out.println("Count = " + line.length);
            System.out.println("Sum = " + line[0]);
        } else {
            int sum = 0;
            for (String s : line) {
                sum += parseInt.apply(s);
            }
            System.out.println("Count = " + line.length);
            System.out.println("Sum = " + sum);
        }
    }
}
