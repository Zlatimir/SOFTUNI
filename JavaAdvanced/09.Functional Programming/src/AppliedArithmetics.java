import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by Zlatimir Ivanov on 10.1.2021 г..
 */

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> add = e -> Arrays.stream(e).map(x -> x += 1).toArray();
        Function<int[], int[]> multiply = e -> Arrays.stream(e).map(x -> x *= 2).toArray();
        Function<int[], int[]> subtract = e -> Arrays.stream(e).map(x -> x -= 1).toArray();
        Consumer<int[]> print = e -> Arrays.stream(e).forEach(x -> System.out.print(x + " "));

        String input = sc.nextLine();
        while (!input.equals("end")){
                switch (input){
                    case "add":
                        nums = add.apply(nums);
                        break;
                    case "subtract":
                        nums = subtract.apply(nums);
                        break;
                    case "multiply":
                        nums = multiply.apply(nums);
                        break;
                    case "print":
                        print.accept(nums);
                        System.out.println();
                        break;
                }
            input = sc.nextLine();
        }

    }
}
