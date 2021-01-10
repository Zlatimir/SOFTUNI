import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Zlatimir Ivanov on 10.1.2021 г..
 */

public class ReverseAndExlude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        int n = Integer.parseInt(sc.nextLine());

        Predicate<Integer> divisibleByN = e -> e % n == 0;
        Consumer<List<Integer>> printList = e -> e.forEach(x -> System.out.print(x + " "));

        numbers.removeIf(divisibleByN);
        Collections.reverse(numbers);
        printList.accept(numbers);
    }
}
