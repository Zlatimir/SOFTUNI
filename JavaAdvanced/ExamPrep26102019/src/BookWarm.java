import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 20.1.2021 г..
 */

public class BookWarm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String initialString = sc.nextLine();

        int n = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] arr = sc.nextLine().toCharArray();
            matrix[i] = arr;
        }

        boolean flag = false;
        int currentRow = 0;
        int currentCol = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'P'){
                    currentRow = i;
                    currentCol = j;
                    flag = true;
                    break;
                }
                if (flag) break;
            }
        }

        int changeRow = 0;
        int changeCol = 0;
        String command = sc.nextLine();
        while (!command.equals("end")){
            switch (command){
                case "up":
                    changeRow = -1;
                    changeCol = 0;
                    break;
                case "down":
                    changeRow = 1;
                    changeCol = 0;
                    break;
                case "left":
                    changeRow = 0;
                    changeCol = -1;
                    break;
                case "right":
                    changeRow = 0;
                    changeCol = 1;
                    break;
            }

            if (isOut(n, currentRow, currentCol, changeRow, changeCol)){
                changeRow = 0;
                changeCol = 0;
                initialString = trimString(initialString);
            }

            int newRow = currentRow + changeRow;
            int newCol = currentCol + changeCol;
            if (matrix[newRow][newCol] != '-' && matrix[newRow][newCol] != 'P'){
                initialString += matrix[newRow][newCol];
            }
            matrix[currentRow][currentCol] = '-';
            matrix[newRow][newCol] = 'P';
            currentRow = newRow;
            currentCol = newCol;

            command = sc.nextLine();
        }

        System.out.println(initialString);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static String trimString(String initialString) {
        if (initialString.length() == 0) return "";
        return initialString.substring(0, initialString.length() - 1);
    }

    private static boolean isOut(int n, int currentRow, int currentCol, int changeRow, int changeCol) {
        int newRow = currentRow + changeRow;
        int newCol = currentCol + changeCol;
        return (newRow < 0 || newRow >= n || newCol < 0 || newCol >= n);
    }
}
