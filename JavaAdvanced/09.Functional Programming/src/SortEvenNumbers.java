import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Zlatimir Ivanov on 10.1.2021 г..
 */

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ints = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt).filter(e -> e % 2 == 0)
                .toArray();

        System.out.println(Arrays.stream(ints).mapToObj(Integer::toString).collect(Collectors.joining(", ")));

        System.out.println(Arrays.stream(ints).sorted().mapToObj(Integer::toString).collect(Collectors.joining(", ")));
    }
}
