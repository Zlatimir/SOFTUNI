import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 26.12.2020 г..
 */

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();
        String input = sc.nextLine();

        while (!input.equals("search")){
            String[] data = input.split("-");
            phonebook.put(data[0], data[1]);
            input = sc.nextLine();
        }

        input = sc.nextLine();
        while (!input.equals("stop")){
            if (phonebook.containsKey(input)){
                System.out.println(input + " -> " + phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
            input = sc.nextLine();
        }
    }
}
