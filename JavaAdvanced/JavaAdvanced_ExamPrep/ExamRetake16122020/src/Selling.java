import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 13.2.2021 г..
 */

public class Selling {

    private static int playerRow;
    private static int playerCol;
    private static int[][] pillars = new int[2][2];
    private static boolean isFirstPillar = true;
    private static boolean isOut = false;
    private static int money;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            if (line.contains("S")){
                playerRow = i;
                playerCol = line.indexOf("S");
            }
            if (line.contains("O")){
                if (isFirstPillar){
                    pillars[0][0] = i;
                    pillars[0][1] = line.indexOf("O");
                    isFirstPillar = false;
                } else {
                    pillars[1][0] = i;
                    pillars[1][1] = line.indexOf("O");
                }
            }
            matrix[i] = line.toCharArray();
        }

        while (!isOut && money <= 50){
            int changeRow = 0;
            int changeCol = 0;
            String command = sc.nextLine();
            switch (command){
                case "up":
                    changeRow = -1;
                    move(matrix, changeRow, changeCol);
                    break;
                case "down":
                    changeRow = 1;
                    move(matrix, changeRow, changeCol);
                    break;
                case "left":
                    changeCol = -1;
                    move(matrix, changeRow, changeCol);
                    break;
                case "right":
                    changeCol = 1;
                    move(matrix, changeRow, changeCol);
                    break;
            }
        }

        if (isOut){
            System.out.println("Bad news, you are out of the bakery.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.println("Money: " + money);
        printMatrix(matrix);
    }

    private static void move(char[][] matrix, int changeRow, int changeCol) {
        matrix[playerRow][playerCol] = '-';
        int newRow = playerRow + changeRow;
        int newCol = playerCol + changeCol;
        if (newRow < 0 || newRow == matrix.length || newCol < 0 || newCol == matrix.length){
            isOut = true;
        } else {
            if (newRow == pillars[0][0] && newCol == pillars[0][1]){
                matrix[newRow][newCol] = '-';
                newRow = pillars[1][0];
                newCol = pillars[1][1];
                replacePlayer(matrix, newRow, newCol);
            } else if (newRow == pillars[1][0] && newCol == pillars[1][1]){
                matrix[newRow][newCol] = '-';
                newRow = pillars[0][0];
                newCol = pillars[0][1];
                replacePlayer(matrix, newRow, newCol);
            } else if (Character.isDigit(matrix[newRow][newCol])){
                money += matrix[newRow][newCol] - '0';
                replacePlayer(matrix, newRow, newCol);
            } else {
                replacePlayer(matrix, newRow, newCol);
            }

        }


    }

    private static void replacePlayer(char[][] matrix, int newRow, int newCol) {
        playerRow = newRow;
        playerCol = newCol;
        matrix[playerRow][playerCol] = 'S';
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
