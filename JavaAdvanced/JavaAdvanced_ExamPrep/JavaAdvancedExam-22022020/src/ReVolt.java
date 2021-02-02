import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 1.2.2021 г..
 */

public class ReVolt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sizeMatrix = Integer.parseInt(sc.nextLine());
        int countCommands = Integer.parseInt(sc.nextLine());

        char[][]matrix = readMatrix(sizeMatrix, sc);

        int playerRow = -1;
        int playerCol = -1;
        boolean isFound = false;
        for (int i = 0; i < sizeMatrix; i++) {
            for (int j = 0; j < sizeMatrix; j++) {
                if (matrix[i][j] == 'f'){
                    playerRow = i;
                    playerCol = j;
                    isFound = true;
                    break;
                }
                if (isFound) break;
            }
        }
        matrix[playerRow][playerCol] = '-';
        boolean win = false;

        for (int i = 0; i < countCommands; i++) {
            String command = sc.nextLine();
            int rowChange = 0;
            int colChange = 0;

            switch (command){
                case "up":
                    rowChange = -1;
                    break;
                case "down":
                    rowChange = 1;
                    break;
                case "left":
                    colChange = -1;
                    break;
                case "right":
                    colChange = 1;
                    break;
            }
            int newRow = playerRow + rowChange;
            newRow = validateIndex(sizeMatrix, newRow);
            int newCol = playerCol + colChange;
            newCol = validateIndex(sizeMatrix, newCol);
            char symbol = matrix[newRow][newCol];
            switch (symbol){
                case 'B':
                    switch (command){
                        case "up":
                            newRow = newRow - 1;
                            newRow = validateIndex(sizeMatrix, newRow);
                            break;
                        case "down":
                            newRow = newRow + 1;
                            newRow = validateIndex(sizeMatrix, newRow);
                            break;
                        case "left":
                            newCol = newCol - 1;
                            newCol = validateIndex(sizeMatrix, newCol);
                            break;
                        case "right":
                            newCol = newCol + 1;
                            newCol = validateIndex(sizeMatrix, newCol);
                            break;
                    }
                    break;
                case 'T':
                    switch (command){
                        case "up":
                            newRow = newRow + 1;
                            break;
                        case "down":
                            newRow = newRow - 1;
                            break;
                        case "left":
                            newCol = newCol + 1;
                            break;
                        case "right":
                            newCol = newCol - 1;
                            break;
                    }
                    break;
                case 'F':
                    win = true;
                    break;
            }
            playerRow = newRow;
            playerCol = newCol;
            if (win) break;
        }
        if (win){
            System.out.println("Player won!");
            matrix[playerRow][playerCol] = 'f';
        } else {
            System.out.println("Player lost!");
            matrix[playerRow][playerCol] = 'f';
        }

        printMatrix(matrix);

    }

    private static int validateIndex(int sizeMatrix, int index) {
        if (index < 0){
            return sizeMatrix - 1;
        } else if (index == sizeMatrix){
            return 0;
        } else return index;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(int sizeMatrix, Scanner sc) {
        char[][] array = new char[sizeMatrix][sizeMatrix];
        for (int i = 0; i < sizeMatrix; i++) {
            String input = sc.nextLine();
            array[i] = input.toCharArray();
        }
        return array;
    }
}
