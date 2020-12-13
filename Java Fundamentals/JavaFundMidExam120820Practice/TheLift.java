package JavaFundMidExam120820Practice;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 9.10.2020 г..
 */

public class TheLift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int waitingPeople = Integer.parseInt(sc.nextLine());
        String[] wagons = sc.nextLine().split("\\s+");
        int countWagons = wagons.length;
        int[] peopleInWagons = new int[countWagons];
        for (int i = 0; i < countWagons; i++){
            peopleInWagons[i] = Integer.parseInt(wagons[i]);
        }

        for (int i = 0; i < countWagons; i++) {
            int spaceLeft = 4 - peopleInWagons[i];
            if (waitingPeople >= spaceLeft){
                peopleInWagons[i] += spaceLeft;
                waitingPeople -= spaceLeft;
            } else {
                peopleInWagons[i] = waitingPeople;
                waitingPeople -= spaceLeft;
            }
        }
        if (waitingPeople > 0){
            System.out.printf("There isn't enough space! %d people in a queue!%n", waitingPeople);
        } else if (waitingPeople < 0){
            System.out.println("The lift has empty spots!");
        }

        for (int x : peopleInWagons) {
            System.out.print(x + " ");
        }

    }
}
