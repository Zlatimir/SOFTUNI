import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Created by Zlatimir Ivanov on 10.1.2021 г..
 */

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> findMin = e -> {
            int min = Integer.MAX_VALUE;
            for (Integer num : e) {
                if (num < min) min = num;
            }
            return min;
        };

        System.out.println(findMin.apply(numbers));
    }
}
