package JavaFundExam04042020Practice;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 21.11.2020 г..
 */

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        String input = sc.nextLine();
        while (!input.equals("Generate")) {
            String[] data = input.split(">>>");
            String command = data[0];
            switch (command) {
                case "Contains":
                    String subString = data[1];
                    if (password.contains(subString)) {
                        System.out.printf("%s contains %s%n", password, subString);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String upOrLow = data[1];
                    int startIndex = Integer.parseInt(data[2]);
                    int endIndex = Integer.parseInt(data[3]);
                    String newPass = "";
                    if (startIndex > 0) {
                        newPass += password.substring(0, startIndex);
                    }
                    if (upOrLow.equals("Upper")){
                        newPass += password.substring(startIndex, endIndex).toUpperCase();
                    } else {
                        newPass += password.substring(startIndex, endIndex).toLowerCase();
                    }
                    newPass += password.substring(endIndex);
                    password = newPass;
                    System.out.println(password);
                    break;
                case "Slice":
                    int start = Integer.parseInt(data[1]);
                    int end = Integer.parseInt(data[2]);
                    newPass = "";
                    if (start > 0) {
                        newPass += password.substring(0, start);
                    }
                    newPass += password.substring(end);
                    password = newPass;
                    System.out.println(password);
                    break;
            }
            input = sc.nextLine();
        }
        System.out.printf("Your activation key is: %s%n", password);
    }
}
