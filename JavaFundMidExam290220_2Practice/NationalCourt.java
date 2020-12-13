package JavaFundMidExam290220_2Practice;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 3.11.2020 г..
 */

public class NationalCourt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = Integer.parseInt(sc.nextLine());
        int second = Integer.parseInt(sc.nextLine());
        int third = Integer.parseInt(sc.nextLine());
        int peopleCount = Integer.parseInt(sc.nextLine());
        int totalEfficiency = first + second + third;
        int timeNeeded = 0;

        while (peopleCount > 0){
            timeNeeded ++;
            if (timeNeeded % 4 == 0){
                continue;
            }
            peopleCount -= totalEfficiency;
        }

        System.out.printf("Time needed: %dh.", timeNeeded);
    }
}
