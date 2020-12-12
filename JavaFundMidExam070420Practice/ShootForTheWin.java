package JavaFundMidExam070420Practice;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 31.10.2020 г..
 */

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int[] target = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            target[i] = Integer.parseInt(line[i]);
        }
        int countShots = 0;
        boolean[] isShot = new boolean[target.length];
        for (int i = 0; i < isShot.length; i++) {
            isShot[i] = false;
        }
        String input = sc.nextLine();
        while (!input.equals("End")){
            int index = Integer.parseInt(input);
            if (index < 0 || index >= target.length){
                input = sc.nextLine();
                continue;
            }
            if (isShot[index]){
                input = sc.nextLine();
                continue;
            }
            int value = target[index];
            target[index] = -1;
            isShot[index] = true;
            countShots ++;

            for (int i = 0; i < target.length; i++) {
                if (isShot[i]){
                    continue;
                }
                if (target[i] > value){
                    target[i] -= value;
                } else {
                    target[i] += value;
                }
            }

            input = sc.nextLine();
        }
        System.out.printf("Shot targets: %d ->", countShots);
        for (int i = 0; i < target.length; i++) {
            System.out.print(" " + target[i]);
        }
    }
}
