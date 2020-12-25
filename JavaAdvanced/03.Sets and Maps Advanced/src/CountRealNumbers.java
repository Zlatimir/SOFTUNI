import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 25.12.2020 г..
 */

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] numbers = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])){
                map.put(numbers[i], 1);
            } else {
                map.put(numbers[i], map.get(numbers[i]) + 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
