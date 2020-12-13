package JavaFundExam150820Practice;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 7.12.2020 г..
 */

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();

        String input = sc.nextLine();
        while (!input.equals("Decode")){
            String[] data = input.split("\\|");
            String command = data[0];
            switch (command){
                case "Move":
                    if (!data[1].isEmpty()) {
                        data[1] = data[1].trim();
                        int numberOfLetters = Integer.parseInt(data[1]);
                        message = move(message, numberOfLetters);
                    }
                    break;
                case "Insert":
                    if (!data[1].isEmpty()) {
                        data[1] = data[1].trim();
                        int index = Integer.parseInt(data[1]);
                        String value = data[2];
                        message = insert(message, index, value);
                    }
                    break;
                case "ChangeAll":
                    String substring = data[1];
                    String replacement = data[2];
                    message = message.replace(substring, replacement);
                    break;
                    default:
                        System.out.println("Unknown command: " + command);
            }
            input = sc.nextLine();
        }

        System.out.println("The decrypted message is: " + message);
    }

    private static String insert(String message, int index, String value) {
        if (index < 0 || index > message.length()){
            return message;
        }

        String first = message.substring(0, index);
        String second = "";
        if (index < message.length()){
            second = message.substring(index);
        }
        return first + value + second;
    }

    private static String move(String message, int numberOfLetters) {
        if (numberOfLetters > message.length() || numberOfLetters <=0){
            return message;
        } else {
            String first = message.substring(0, numberOfLetters);
            String second = message.substring(numberOfLetters);
            return second + first;
        }
    }
}
