package JavaFundMidExam160419Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 5.11.2020 г..
 */

public class EasterGifts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        List<String> gifts = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            gifts.add(line[i]);
        }

        String input = sc.nextLine();
        while (!input.equals("No Money")) {
            String[] commandAndParam = input.split(" ");
            String command = commandAndParam[0];
            String item = commandAndParam[1];
            switch (command) {
                case "OutOfStock":
                    while (gifts.contains(item)) {
                        gifts.set(gifts.indexOf(item), "None");
                    }
                    break;
                case "JustInCase":
                    gifts.set(gifts.size() - 1, item);
                    break;
                case "Required":
                    int index = Integer.parseInt(commandAndParam[2]);
                    if (index >= 0 && index < gifts.size()) {
                        gifts.set(index, item);
                    }
                    break;
            }
            input = sc.nextLine();
        }
        while (gifts.contains("None")){
            gifts.remove("None");
        }
        for (int i = 0; i < gifts.size() - 1; i++) {
            System.out.print(gifts.get(i) + " ");
        }
        System.out.println(gifts.get(gifts.size() - 1));
    }
}
