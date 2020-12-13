package JavaFundMapsLambdaAndStreamApi;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 10.11.2020 г..
 */

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<Character, Integer> list = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' '){
                char ch = input.charAt(i);
                if (list.containsKey(ch)){
                    list.put(ch, list.get(ch) + 1);
                } else {
                    list.put(ch, 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : list.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
