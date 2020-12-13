package JavaFundMidExam120820Practice;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 10.10.2020 г..
 */

public class MemoryGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputAsString = input.split("\\s+");
        ArrayList<String> list = new ArrayList<>(inputAsString.length);
        for (int i = 0; i < inputAsString.length; i++) {
            list.add(i, inputAsString[i]);
        }
        int moves = 0;
        while (true) {
            input = sc.nextLine();
            if (input.equals("end")) {
                break;
            }
            if (input.equals("")) {
                continue;
            }
            moves++;
            inputAsString = input.split("\\s+");
            int firstIndex;
            int secondIndex;
            if (inputAsString[0].matches("-?\\d+")) {
                firstIndex = Integer.parseInt(inputAsString[0]);
            } else {
                firstIndex = 0;
            }
            if (inputAsString[1].matches("-?\\d+")) {
                secondIndex = Integer.parseInt(inputAsString[1]);
            } else {
                secondIndex = 0;
            }

            if (firstIndex < 0 || secondIndex < 0
                    || firstIndex >= list.size()
                    || secondIndex >= list.size()
                    || firstIndex == secondIndex) {
                System.out.println("Invalid input! Adding additional elements to the board");
                String additional = "-" + moves + "a";
                int positionToInsert = list.size() / 2;
                list.add(positionToInsert, additional);
                list.add(positionToInsert, additional);
                continue;
            }
            String first = list.get(firstIndex);
            String second = list.get(secondIndex);
            if (first.equals(second)) {
                System.out.printf("Congrats! You have found matching elements - %s!%n", first);
                if (firstIndex < secondIndex) {
                    list.remove(secondIndex);
                    list.remove(firstIndex);
                } else {
                    list.remove(firstIndex);
                    list.remove(secondIndex);
                }
                if (list.size() == 0) {
                    System.out.printf("You have won in %d turns!", moves);
                    break;
                }
            } else {
                System.out.println("Try again!");
            }
        }
        if (list.size() != 0) {
            System.out.println("Sorry you lose :(");
        }

        for (String s : list) {
            System.out.print(s + " ");
        }
    }
}
