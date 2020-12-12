package JavaFundMidExam050720Practice;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 25.10.2020 г..
 */

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstEmployeeEfficiency = Integer.parseInt(sc.nextLine());
        int secondEmployeeEfficiency = Integer.parseInt(sc.nextLine());
        int thirdEmployeeEfficiency = Integer.parseInt(sc.nextLine());
        int countOfStudents = Integer.parseInt(sc.nextLine());

        int timeNeeded = 0;
        double totalEfficiency = firstEmployeeEfficiency + secondEmployeeEfficiency + thirdEmployeeEfficiency;
        if (countOfStudents != 0){
            while(countOfStudents > 0){
                countOfStudents -= totalEfficiency;
                timeNeeded ++;
                if (timeNeeded %4 == 0){
                    timeNeeded ++;
                }
            }
        }

        System.out.printf("Time needed: %dh.", timeNeeded);

    }
}
