import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 27.12.2020 г..
 */

public class Bee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        char[][] field = new char[n][];

        for (int i = 0; i < n; i++) {
            field[i] = sc.nextLine().toCharArray();
        }
        int currentRow = 0;
        int currentCol = 0;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j] == 'B') {
                    currentRow = i;
                    currentCol = j;
                    break;
                }
            }
        }
        int pollinated = 0;
        boolean isOut = false;
        String command = sc.nextLine();

        while (!command.equals("End")) {
            int moveRow = 0;
            int moveCol = 0;
            int bonus = 0;

            switch (command) {
                case "up":
                    moveRow = -1;
                    break;
                case "down":
                    moveRow = 1;
                    break;
                case "left":
                    moveCol = -1;
                    break;
                case "right":
                    moveCol = 1;
                    break;

            }

            if (currentRow + moveRow >= 0 && currentRow + moveRow < field.length
                    && currentCol + moveCol >= 0 && currentCol + moveCol < field[0].length){
                field[currentRow][currentCol] = '.';
                currentRow += moveRow;
                currentCol += moveCol;
                if (field[currentRow][currentCol] == 'f'){
                    pollinated++;
                    field[currentRow][currentCol] = '.';
                } else if (field[currentRow][currentCol] == 'O'){
                    bonus = 1;
                    field[currentRow][currentCol] = '.';
                }
                field[currentRow][currentCol] = 'B';

            } else {
                field[currentRow][currentCol] = '.';
                isOut = true;
                break;
            }

            if (bonus == 0) command = sc.nextLine();

        }

        if (isOut) System.out.println("The bee got lost!");

        if (pollinated >= 5){
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinated);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", (5 - pollinated));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

}
