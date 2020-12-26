import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 26.12.2020 г..
 */

public class FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, String> list = new LinkedHashMap<>();
        String name = sc.nextLine();

        while (!name.equals("stop")) {
            String email = sc.nextLine();
            list.put(name, email);

            name = sc.nextLine();
        }

        list.entrySet().stream().filter(e -> {
                    boolean res = (!e.getValue().endsWith(".us") && !e.getValue().endsWith(".uk") && !e.getValue().endsWith(".com"));
                    return res;
                }).forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}
