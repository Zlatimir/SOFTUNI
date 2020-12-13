package JavaFundMapsLambdaAndStreamApi;

import java.util.*;

/**
 * Created by Zlatimir Ivanov on 17.11.2020 г..
 */

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> users = new TreeMap<>();

        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split(" -> ");
            String companyName = data[0];
            String userID = data[1];
            users.putIfAbsent(companyName, new ArrayList<>());
            if (!users.get(companyName).contains(userID)) {
                users.get(companyName).add(userID);
            }
            input = sc.nextLine();
        }
        users.entrySet().stream().forEach(c -> {
            System.out.println(c.getKey());
            c.getValue().stream().forEach(u -> {
                System.out.println("-- " + u);

            });
        });
    }
}

