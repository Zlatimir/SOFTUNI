import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 5.2.2021 г..
 */

public class Snake {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[n][n];
        int snakeRow = 0;
        int snakeCol = 0;
        boolean hasLair = false;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("S")){
                snakeRow = i;
                snakeCol = line.indexOf("S");
            }
            if (line.contains("B")){
                hasLair = true;
            }
        }

        int [][] burrows = new int[2][2];
        if (hasLair){
            boolean foundBurrow = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 'B' && !foundBurrow){
                        burrows[0][0] = i;
                        burrows[0][1] = j;
                        foundBurrow = true;
                    } else if (matrix[i][j] == 'B'){
                        burrows[1][0] = i;
                        burrows[1][1] = j;
                    }
                }
            }
        }

        int food = 0;
        boolean isOut = false;

        while (!isOut && food < 10){
            String command = sc.nextLine();
            int changeRow = 0;
            int changeCol = 0;
            switch (command){
                case "up":
                    changeRow = -1;
                    break;
                case "down":
                    changeRow = 1;
                    break;
                case "left":
                    changeCol = -1;
                    break;
                case "right":
                    changeCol = 1;
                    break;
            }
            int newRow = snakeRow + changeRow;
            int newCol = snakeCol + changeCol;
            if (newRow < 0 || newRow == n || newCol < 0 || newCol == n){
                isOut =true;
                matrix[snakeRow][snakeCol] = '.';
                break;
            }
            if (hasLair){
                if (newRow == burrows[0][0] && newCol == burrows[0][1]){
                    newRow = burrows[1][0];
                    newCol = burrows[1][1];
                    matrix[burrows[0][0]][burrows[0][1]] = '.';
                } else if (newRow == burrows[1][0] && newCol == burrows[1][1]){
                    newRow = burrows[0][0];
                    newCol = burrows[0][1];
                    matrix[burrows[1][0]][burrows[1][1]] = '.';
                }
            }
            if (matrix[newRow][newCol] == '*'){
                food++;
            }
            matrix[snakeRow][snakeCol] = '.';
            snakeRow = newRow;
            snakeCol = newCol;
        }


        if (isOut){
            System.out.println("Game over!");
        }
        if (food >= 10){
            matrix[snakeRow][snakeCol] = 'S';
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + food);




        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }


    }
}
