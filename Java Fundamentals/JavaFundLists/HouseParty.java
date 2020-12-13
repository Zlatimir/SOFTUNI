package JavaFundLists;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 4.10.2020 г..
 */

public class HouseParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<String> guests = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] wordsOfInput = input.split("\\s+");
            String name = wordsOfInput[0];
            if (wordsOfInput.length == 3){
                if (guests.contains(name)){
                    System.out.println(name + " is already in the list!");
                } else {
                    guests.add(name);
                }
            } else {
                if (guests.contains(name)){
                    guests.remove(name);
                } else {
                    System.out.println(name + " is not in the list!");
                }
            }
        }
        for (String name : guests) {
            System.out.println(name);
        }
    }
}
