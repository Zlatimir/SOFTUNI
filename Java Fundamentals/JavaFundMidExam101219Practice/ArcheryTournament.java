package JavaFundMidExam101219Practice;

import java.util.Scanner;


/**
 * Created by Zlatimir Ivanov on 30.10.2020 г..
 */

public class ArcheryTournament {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split("\\|");
        int[] target = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            target[i] = Integer.parseInt(line[i]);
        }
        int points = 0;

        String input = sc.nextLine();
        while (!input.equals("Game over")) {
            String[] commandAndIndexes = input.split("@");
            String command = commandAndIndexes[0];
            switch (command) {
                case "Shoot Left":
                    int index = Integer.parseInt(commandAndIndexes[1]);
                    int range = Integer.parseInt(commandAndIndexes[2]);
                    if (index < 0 || index > target.length - 1) {
                        input = sc.nextLine();
                        continue;
                    }
                    points += shootLeft(target, index, range);
                    break;
                case "Shoot Right":
                    index = Integer.parseInt(commandAndIndexes[1]);
                    range = Integer.parseInt(commandAndIndexes[2]);
                    if (index < 0 || index > target.length - 1) {
                        input = sc.nextLine();
                        continue;
                    }
                    points += shootRight(target, index, range);
                    break;
                case "Reverse":
                    reverseTarget(target);
                    break;
            }
            input = sc.nextLine();
        }


        printOutput(target, points);
    }

    private static int shootLeft(int[] target, int index, int range) {
        int newIndex = index - range;
        int points;
        while (newIndex < 0) {
            newIndex += target.length;
        }
        if (target[newIndex] < 5) {
            points = target[newIndex];
            target[newIndex] = 0;
        } else {
            target[newIndex] -= 5;
            points = 5;
        }
        return points;
    }

    private static int shootRight(int[] target, int index, int range) {
        int newIndex = index + range;
        int points;
        while (newIndex >= target.length) {
            newIndex -= target.length;
        }
        if (target[newIndex] < 5) {
            points = target[newIndex];
            target[newIndex] = 0;
        } else {
            target[newIndex] -= 5;
            points = 5;
        }
        return points;
    }


    private static void reverseTarget(int[] target) {
        for (int i = 0; i < target.length / 2; i++) {
            int temp = target[i];
            target[i] = target[target.length - 1 - i];
            target[target.length - i - 1] = temp;
        }
    }

    private static void printOutput(int[] target, int points) {
        for (int i = 0; i < target.length - 1; i++) {
            System.out.print(target[i] + " - ");
        }
        System.out.println(target[target.length - 1]);
        System.out.printf("Iskren finished the archery tournament with %d points!", points);
    }
}
