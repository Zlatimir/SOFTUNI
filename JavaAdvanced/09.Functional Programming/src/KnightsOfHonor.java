import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Created by Zlatimir Ivanov on 10.1.2021 г..
 */

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Consumer<String> printItem = s -> System.out.println("Sir " + s);

        String[] input = sc.nextLine().split("\\s+");

        for (String s : input) {
            printItem.accept(s);
        }
    }
}
