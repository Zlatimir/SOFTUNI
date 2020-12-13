package JavaFundMidExam290220_2Practice;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 3.11.2020 г..
 */

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split("@");
        int[] houses = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            houses[i] = Integer.parseInt(line[i]);
        }
        int position = 0;
        String input = sc.nextLine();
        while (!input.equals("Love!")) {
            String[] command = input.split(" ");
            int jump = Integer.parseInt(command[1]);
            position += jump;
            if (position >= houses.length) {
                position = 0;
            }
            if (houses[position] == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", position);
            } else {
                houses[position] -= 2;
                if (houses[position] == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", position);
                }
            }

            input = sc.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", position);
        int count = 0;
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] != 0) {
                count++;
            }
        }
        if (count != 0) {
            System.out.printf("Cupid has failed %d places.", count);
        } else {
            System.out.println("Mission was successful.");
        }
    }
}
