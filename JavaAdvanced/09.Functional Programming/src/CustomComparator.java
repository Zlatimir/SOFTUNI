import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Zlatimir Ivanov on 10.1.2021 г..
 */

public class CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> evenOnly = arr -> Arrays.stream(arr).filter(e -> e%2==0).sorted().toArray();
        Function<int[], int[]> oddOnly = arr -> Arrays.stream(arr).filter(e -> e%2!=0).sorted().toArray();

        int[] even = evenOnly.apply(numbers);
        int[] odd = oddOnly.apply(numbers);

        //Comparator<int[]> comparator =

    }
}
