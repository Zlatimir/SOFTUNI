import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Zlatimir Ivanov on 26.12.2020 г..
 */

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        Map<Character, Integer> count = new TreeMap<>();

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            count.putIfAbsent(ch, 0);
            count.put(ch, count.get(ch) + 1);
        }

        count.entrySet().stream().forEach(e -> System.out.printf("%s: %d time/s%n", e.getKey(), e.getValue()));
    }
}
