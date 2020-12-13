package JavaFundMapsLambdaAndStreamApi;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 10.11.2020 г..
 */

public class AMinerTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        Map<String, Integer> resource = new LinkedHashMap<>();
        while (!input.equals("stop")) {
            int quantity = Integer.parseInt(sc.nextLine());
            if (resource.containsKey(input)){
                resource.put(input, resource.get(input) + quantity);
            } else {
                resource.put(input, Integer.valueOf(quantity));
            }
            input = sc.nextLine();
        }

        for (Map.Entry<String, Integer> entry : resource.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
