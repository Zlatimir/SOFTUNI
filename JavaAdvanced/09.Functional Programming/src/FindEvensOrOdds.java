import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * Created by Zlatimir Ivanov on 10.1.2021 г..
 */

public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String[] bounds = sc.nextLine().split("\\s+");
        int lowerBound = Integer.parseInt(bounds[0]);
        int upperBound = Integer.parseInt(bounds[1]);
        String command = sc.nextLine();

        int[] numbers = IntStream.rangeClosed(lowerBound, upperBound).toArray();
        for (int number : numbers) {
            if (evenOrOdd(command).test(number)) {
                System.out.print(number + " ");
            }
        }

    }

    static Predicate<Integer> evenOrOdd(String command) {
        Predicate<Integer> tester;
        if (command.equals("even")) {
            tester = x -> x % 2 == 0;
        } else {
            tester = x -> x % 2 != 0;
        }
        return tester;
    }
}
