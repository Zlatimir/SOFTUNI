package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int[] dimensions = parseToIntArray(line);
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = fillMatrixWithSequentiolNumbers(rows, cols);

        long sum = 0;

        String command = scanner.nextLine();

        while (!command.equals("Let the Force be with you")) {
            int[] ivoPosition = parseToIntArray(command);

            command = scanner.nextLine();
            int[] evilPosition = parseToIntArray(command);

            int evilRow = evilPosition[0];
            int evilCol = evilPosition[1];

            evilDestroyedCells(matrix, evilRow, evilCol);

            int ivoRow = ivoPosition[0];
            int ivoCol = ivoPosition[1];

            sum = getSumFromIvosDiagonal(matrix, sum, ivoRow, ivoCol);

            command = scanner.nextLine();
        }

        System.out.println(sum);


    }

    public static long getSumFromIvosDiagonal(int[][] matrix, long sum, int ivoRow, int ivoCol) {
        while (ivoRow >= 0 && ivoCol < matrix[1].length) {
            if (ivoRow >= 0 && ivoRow < matrix.length && ivoCol >= 0 && ivoCol < matrix[0].length) {
                sum += matrix[ivoRow][ivoCol];
            }

            ivoCol++;
            ivoRow--;
        }
        return sum;
    }

    public static void evilDestroyedCells(int[][] matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow >= 0 && evilRow < matrix.length && evilCol >= 0 && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    public static int[][] fillMatrixWithSequentiolNumbers(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = value++;
            }
        }
        return matrix;
    }

    public static int[] parseToIntArray(String line) {
        return Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
