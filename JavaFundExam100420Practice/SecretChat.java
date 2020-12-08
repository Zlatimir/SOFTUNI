package JavaFundExam100420Practice;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 30.11.2020 г..
 */

public class SecretChat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        String input = sc.nextLine();
        while (!input.equals("Reveal")){
            String[] data = input.split(":\\|:");
            String command = data[0];
            switch (command){
                case "InsertSpace":
                    int index = Integer.parseInt(data[1]);
                    message = message.substring(0, index) + " " + message.substring(index);
                    System.out.println(message);
                    break;
                case "Reverse":
                    String substring = data[1];
                    if (!message.contains(substring)){
                        System.out.println("error");
                    } else {
                        index = message.indexOf(substring);
                        int length = substring.length();
                        message = message.substring(0, index) + message.substring(index + length) + revers(substring);
                        System.out.println(message);
                    }
                    break;
                case "ChangeAll":
                    substring = data[1];
                    String repacement = data[2];
                    message = message.replaceAll(substring, repacement);
                    System.out.println(message);
                    break;
            }
            input = sc.nextLine();
        }
        System.out.println("You have a new text message: " + message);
    }



    private static StringBuilder revers(String substring) {
        StringBuilder reversed = new StringBuilder();
        for (int i = substring.length() - 1; i >= 0 ; i--) {
            reversed.append(substring.charAt(i));
        }
        return reversed;
    }
}
