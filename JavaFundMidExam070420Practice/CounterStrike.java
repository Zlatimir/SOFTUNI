package JavaFundMidExam070420Practice;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 31.10.2020 г..
 */

public class CounterStrike {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int energy = Integer.parseInt(sc.nextLine());
        int wonBattles = 0;
        boolean won = true;
        String input = sc.nextLine();
        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);
            if (energy < distance) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wonBattles, energy);
                won = false;
                break;
            }
            energy -= distance;
            wonBattles++;
            if (wonBattles % 3 == 0) {
                energy += wonBattles;
            }
            input = sc.nextLine();
        }
        if (won) {
            System.out.printf("Won battles: %d. Energy left: %d", wonBattles, energy);
        }
    }
}
