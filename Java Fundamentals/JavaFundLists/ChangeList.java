package JavaFundLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 4.10.2020 г..
 */

public class ChangeList {

    private static ArrayList<Integer> deleteElement(ArrayList<Integer> list, int n) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == n) {
                list.remove(i);
            }
        }
        return list;
    }

    private static ArrayList<Integer> insertElementAtPosition(ArrayList<Integer> list, int element, int index) {
        list.add(index, element);
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputList = sc.nextLine();
        if (inputList.length() != 0) {
            String[] inputAsString = inputList.split("\\s+");
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < inputAsString.length; i++) {
                if (inputAsString[i].matches("-?\\d+")) {
                    list.add(Integer.parseInt(inputAsString[i]));
                }
            }

            while (true) {
                String input = sc.nextLine();
                if (input.equals("end")) {
                    break;
                }
                if (input.contains("Delete")) {
                    input = input.substring(7);
                    if (input.matches("-?\\d+")) {
                        int number = Integer.parseInt(input);

                        deleteElement(list, number);
                    }
                } else {
                    if (input.contains("Insert")) {
                        input = input.substring(7);
                        String[] numbersAsString = input.split("\\s+");
                        if (numbersAsString[0].matches("-?\\d+") && numbersAsString[1].matches("-?\\d+")) {
                            int num = Integer.parseInt(numbersAsString[0]);
                            int index = Integer.parseInt(numbersAsString[1]);
                            if (index >= 0 && index < list.size()) {
                                insertElementAtPosition(list, num, index);
                            } else if (index == 0){
                                insertElementAtPosition(list, num, 0);
                            }
                        }
                    }
                }
            }
            for (Integer n : list) {
                System.out.print(n + " ");
            }
        }
    }
}
