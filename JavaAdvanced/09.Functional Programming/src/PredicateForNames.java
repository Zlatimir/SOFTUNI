import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Zlatimir Ivanov on 10.1.2021 г..
 */

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<String> list = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        Predicate<String> tester = str -> str.length() > n;
        Consumer<List<String>> print = i ->  i.stream().forEach(e -> System.out.println(e));

        list.removeIf(tester);
        print.accept(list);
    }
}
