package JavaFundLists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 3.10.2020 г..
 */

public class Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputWagons = sc.nextLine();
        String[] wagonsAsString = inputWagons.split(" ");
        List<Integer> wagons = new ArrayList<>();
        for (int i = 0; i < wagonsAsString.length; i++) {
            wagons.add(Integer.parseInt(wagonsAsString[i]));
        }
        int maxCapacity = Integer.parseInt(sc.nextLine());

        while (true) {
            String input = sc.nextLine();
            System.out.println();
            if (input.equals("end")) {
                break;
            }
            if (input.contains("Add")) {
                int passengersToAdd = Integer.parseInt(input.substring(4));
                wagons.add(passengersToAdd);
            } else {
                int passengersToAdd = Integer.parseInt(input);
                for (int i = 0; i < wagons.size(); i++) {
                    if (wagons.get(i) + passengersToAdd <= maxCapacity) {
                        wagons.set(i, wagons.get(i) + passengersToAdd);
                        break;
                    }
                }
            }
        }
        for (int x : wagons) {
            System.out.print(x + " ");
        }
    }
}
