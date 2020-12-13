package JavaFundMidExam290220_2Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 3.11.2020 г..
 */

public class ShoppingList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split("!");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            list.add(line[i]);
        }
        String input = sc.nextLine();
        while (!input.equals("Go Shopping!")){
            String[] commandAndParam = input.split(" ");
            String command = commandAndParam[0];
            String item = commandAndParam[1];
            switch (command){
                case "Urgent":
                    if (!list.contains(item)){
                        list.remove(item);
                        list.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    if (list.contains(item)){
                        list.remove(item);
                    }
                    break;
                case "Correct":
                    String newItem = commandAndParam[2];
                    if (list.contains(item)){
                        int index = list.indexOf(item);
                        list.set(index, newItem);
                    }
                    break;
                case "Rearrange":
                    if (list.contains(item)) {
                        list.remove(item);
                        list.add(item);
                    }
                    break;
            }
            input = sc.nextLine();
        }
        for (int i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i) + ", ");
        }
        System.out.println(list.get(list.size() - 1));
    }
}
