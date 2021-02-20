import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 20.2.2021 г..
 */

public class Exam_Problem_02_Bomb {
    static int sapperRow = 0;
    static int sapperCol = 0;
    static int exitRow = 0;
    static int exitCol = 0;
    static int totalBombs = 0;
    static int bombCount = 0;
    static boolean exit = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[n][n];

        String[] commands = sc.nextLine().split(",");


        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            matrix[i] = line.replaceAll("\\s+", "").toCharArray();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
                    totalBombs++;
                }
            }
            if (line.contains("s")) {
                sapperRow = i;
                sapperCol = line.indexOf("s") / 2;
            }
            if (line.contains("e")) {
                exitRow = i;
                exitCol = line.indexOf("e") / 2;
            }
        }

        for (int i = 0; i < commands.length; i++) {
            int changeRow = 0;
            int changeCol = 0;
            switch (commands[i]){
                case "up":
                    if (sapperRow != 0){
                        changeRow = -1;
                    }
                    break;
                case "down":
                    if (sapperRow != n - 1){
                        changeRow = 1;
                    }
                    break;
                case "left":
                    if (sapperCol != 0){
                        changeCol = -1;
                    }
                    break;
                case "right":
                    if (sapperCol != n - 1){
                        changeCol = 1;
                    }
                    break;
            }
            move(matrix, changeRow, changeCol);
            if (exit) {
                break;
            }
        }

        if (bombCount == totalBombs){
            System.out.println("Congratulations! You found all bombs!");
        } else if (exit){
            System.out.println("END! " + (totalBombs - bombCount) + " bombs left on the field");
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", (totalBombs - bombCount), sapperRow, sapperCol);
        }


    }

    private static void move(char[][] matrix, int changeRow, int changeCol) {
        matrix[sapperRow][sapperCol] = '+';
        sapperRow += changeRow;
        sapperCol += changeCol;

        if (matrix[sapperRow][sapperCol] == 'B'){
            bombCount++;
            System.out.println("You found a bomb!");
        }
        if (matrix[sapperRow][sapperCol] == 'e'){
            exit = true;
        }

    }
}
