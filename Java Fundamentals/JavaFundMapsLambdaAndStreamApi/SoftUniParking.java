package JavaFundMapsLambdaAndStreamApi;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 13.11.2020 г..
 */

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> users = new LinkedHashMap<>();
        int numberOfCommands = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String command = input[0];
            String userName = input[1];
            if (command.equals("register")) {
                String licencePlate = input[2];
                if (users.get(userName) == null) {
                    users.put(userName, licencePlate);
                    System.out.printf("%s registered %s successfully%n", userName, licencePlate);
                } else {

                    System.out.printf("ERROR: already registered with plate number %s%n", licencePlate);

                }
            } else {
                if (!users.containsKey(userName)) {
                    System.out.printf("ERROR: user %s not found%n", userName);
                } else {
                    users.remove(userName);
                    System.out.printf("%s unregistered successfully%n", userName);
                }
            }

        }
        users.forEach((k, v) -> System.out.printf("%s => %s%n", k, v));
    }
}
