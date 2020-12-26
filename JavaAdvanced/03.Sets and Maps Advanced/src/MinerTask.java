import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 26.12.2020 г..
 */

public class MinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Long> mine = new LinkedHashMap<>();
        String input = sc.nextLine();

        while (!input.equals("stop")){
            long quantity = Integer.parseInt(sc.nextLine());
            mine.putIfAbsent(input, 0l);
            mine.put(input, mine.get(input) + quantity);
            input = sc.nextLine();
        }

        mine.entrySet().stream().forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
