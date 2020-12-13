package JavaFundMidExam160419Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 5.11.2020 г..
 */

public class EasterShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        List<String> shops = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            shops.add(line[i]);
        }
        int n = Integer.parseInt(sc.nextLine());
        String input;
        for (int i = 0; i < n; i++) {
            input = sc.nextLine();
            String[] commandAndParam = input.split(" ");
            String command = commandAndParam[0];
            switch (command) {
                case "Include":
                    shops.add(commandAndParam[1]);
                    break;
                case "Visit":
                    String leftRight = commandAndParam[1];
                    int numberOfShops = Integer.parseInt(commandAndParam[2]);
                    if (numberOfShops <= shops.size()) {
                        for (int j = 0; j < numberOfShops; j++) {
                            if (leftRight.equals("first")) {
                                shops.remove(0);
                            } else {
                                shops.remove(shops.size() - 1);
                            }
                        }
                    }
                    break;
                case "Prefer":
                    int index1 = Integer.parseInt(commandAndParam[1]);
                    int index2 = Integer.parseInt(commandAndParam[2]);
                    if (index1 >= 0 && index2 >= 0 && index1 < shops.size() && index2 < shops.size()){
                        String temp = shops.get(index1);
                        shops.set(index1, shops.get(index2));
                        shops.set(index2, temp);
                    }
                        break;
                case "Place":
                    String shop = commandAndParam[1];
                    int index = Integer.parseInt(commandAndParam[2]);
                    if (index < shops.size() - 1){
                        shops.add(index + 1, shop);
                    }
                    break;
            }
        }

        System.out.println("Shops left:");
        for (int i = 0; i < shops.size() - 1; i++) {
            System.out.print(shops.get(i) + " ");
        }
        System.out.println(shops.get(shops.size() - 1));
    }
}
