package JavaFundMidExam071120Compete;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 7.11.2020 г..
 */

public class Messaging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String input = sc.nextLine();
        while (!input.equals("end")){
            String[] commandAndParam = input.split("\\s+");
            String command = commandAndParam[0];
            String message = commandAndParam[1];
            switch (command){
                case "Chat":
                    list.add(message);
                    break;
                case "Delete":
                    if (list.contains(message)){
                        list.remove(message);
                    }
                    break;
                case "Edit":
                    String newMessage = commandAndParam[2];
                    if (list.contains(message)){
                        int index = list.indexOf(message);
                        list.set(index, newMessage);
                    }
                    break;
                case "Pin":
                    if (list.contains(message)){
                        list.remove(message);
                        list.add(message);
                    }
                    break;
                case "Spam":
                    String[] spam = input.split("\\s+");
                    for (int i = 1; i < spam.length; i++) {
                        list.add(spam[i]);
                    }
                    break;
            }
            input = sc.nextLine();
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
