import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 20.12.2020 г..
 */

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] indexes = sc.nextLine().split("\\s+");
        int rows = Integer.parseInt(indexes[0]);
        int cols = Integer.parseInt(indexes[1]);
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] arr = sc.nextLine().split("\\s+");
            matrix[i] = arr;
        }

        String input = sc.nextLine();

        while (!input.equals("END")) {
            try {
                String[] data = input.split("\\s+");
                if (!data[0].equals("swap")){
                    System.out.println("Invalid input!");
                    input = sc.nextLine();
                    continue;
                }
                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);
                swap(matrix, row1, col1, row2, col2);
                printMatrix(matrix);
                input = sc.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                input = sc.nextLine();
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] swap(String[][] matrix, int row1, int col1, int row2, int col2) {
        String temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
        return matrix;
    }
}
