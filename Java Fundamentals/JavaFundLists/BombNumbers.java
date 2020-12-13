package JavaFundLists;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 5.10.2020 г..
 */

public class BombNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputList = sc.nextLine();
            String[] inputAsString = inputList.split("\\s+");
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < inputAsString.length; i++) {
                if (inputAsString[i].matches("-?\\d+")) {
                    list.add(Integer.parseInt(inputAsString[i]));
                }
            }
        inputList = sc.nextLine();
            inputAsString = inputList.split("\\s+");
            int bomb = Integer.parseInt(inputAsString[0]);
            int power = Integer.parseInt(inputAsString[1]);

        while (list.contains(bomb)){
            for (int i = 1; i <= power; i++) {
                int indexToRemove = list.indexOf(bomb) - 1;
                if (indexToRemove<0){
                    break;
                } else {
                    list.remove(indexToRemove);
                }
            }
            for (int i = 1; i <= power; i++) {
                int indexToRemove = list.indexOf(bomb) + 1;
                if (indexToRemove > list.size() - 1){
                    break;
                } else {
                    list.remove(indexToRemove);
                }
            }

            list.remove(list.indexOf(bomb));
        }
        int sum = 0;
        for (Integer n : list) {
            sum += n;
        }
        System.out.println(sum);
    }
}
