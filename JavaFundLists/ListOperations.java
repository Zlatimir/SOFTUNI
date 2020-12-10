package JavaFundLists;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 4.10.2020 г..
 */

public class ListOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        String line = sc.nextLine();
        String[] numbersAsString = line.split("\\s+");
        for (int i = 0; i < numbersAsString.length; i++) {
            list.add(Integer.parseInt(numbersAsString[i]));
        }

        while (true){
            String input = sc.nextLine();
            if (input.equals("End")){
                break;
            }
            String[] inputAsString = input.split("\\s+");
            if (inputAsString[0].equals("Add")){
                int number = Integer.parseInt(inputAsString[1]);
                list.add(number);
            } else if (inputAsString[0].equals("Remove")){
                int index = Integer.parseInt(inputAsString[1]);
                if (index>=0 && index<list.size()){
                    list.remove(index);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (inputAsString[0].equals("Insert")){
                int number = Integer.parseInt(inputAsString[1]);
                int index = Integer.parseInt(inputAsString[2]);
                if (index>=0 && index<list.size()){
                    list.add(index, number);
                } else {
                    System.out.println("Invalid index");
                }
            } else if (inputAsString[0].equals("Shift")){
                if (inputAsString[1].equals("left")){
                    int iterations = Integer.parseInt(inputAsString[2]);
                    for (int i = 0; i < iterations; i++) {
                        int temp = list.get(0);
                        list.remove(0);
                        list.add(temp);
                    }
                } else if (inputAsString[1].equals("right")){
                    int iterations = Integer.parseInt(inputAsString[2]);
                    for (int i = 0; i < iterations; i++) {
                        int temp = list.get(list.size()-1);
                        list.remove(list.size()-1);
                        list.add(0, temp);
                    }
                }
            }
        }
        for (Integer x : list) {
            System.out.print(x + " ");
        }
    }
}
