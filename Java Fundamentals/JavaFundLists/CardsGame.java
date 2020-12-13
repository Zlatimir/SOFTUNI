package JavaFundLists;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 8.10.2020 г..
 */

public class CardsGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputList = sc.nextLine();
        ArrayList<Integer> firstDeck = readListOfIntegers(inputList);
        inputList = sc.nextLine();
        ArrayList<Integer> secondDeck = readListOfIntegers(inputList);

        while (firstDeck.size() != 0 && secondDeck.size() != 0) {
        if (firstDeck.get(0) > secondDeck.get(0)){
            firstDeck.add(firstDeck.get(0));
            firstDeck.add(secondDeck.get(0));
            secondDeck.remove(0);
            firstDeck.remove(0);

        } else if (secondDeck.get(0) > firstDeck.get(0)){
            secondDeck.add(secondDeck.get(0));
            secondDeck.add(firstDeck.get(0));
            firstDeck.remove(0);
            secondDeck.remove(0);
        } else {
            firstDeck.remove(0);
            secondDeck.remove(0);
        }
        }
        if (firstDeck.size()!=0){
            System.out.println("NextLevel player wins! Sum: " + sum(firstDeck));
        } else {
            System.out.println("Second player wins! Sum: " + sum(secondDeck));
        }
    }

    private static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer n : list) {
            sum += n;
        }
        return sum;
    }


    private static ArrayList<Integer> readListOfIntegers(String inputList){
        String[] inputAsString = inputList.split("\\s+");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < inputAsString.length; i++) {
            if (inputAsString[i].matches("-?\\d+")) {
                list.add(Integer.parseInt(inputAsString[i]));
            }
        }
        return list;
    }
}
