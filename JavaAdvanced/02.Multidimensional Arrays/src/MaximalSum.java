import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 20.12.2020 г..
 */

public class MaximalSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] indexes = sc.nextLine().split("\\s+");
        int rows = Integer.parseInt(indexes[0]);
        int cols = Integer.parseInt(indexes[1]);
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }

        int maxSum = Integer.MIN_VALUE;
        int[][] max3x3 = new int[3][3];
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                int sum = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2]
                        + matrix[i+1][j] + matrix[i+1][j+1] + matrix[i+1][j+2]
                        + matrix[i+2][j] + matrix[i+2][j+1] + matrix[i+2][j+2];
                if (sum > maxSum){
                    maxSum = sum;
                    max3x3[0][0] = matrix[i][j];
                    max3x3[0][1] = matrix[i][j+1];
                    max3x3[0][2] = matrix[i][j+2];

                    max3x3[1][0] = matrix[i+1][j];
                    max3x3[1][1] = matrix[i+1][j+1];
                    max3x3[1][2] = matrix[i+1][j+2];

                    max3x3[2][0] = matrix[i+2][j];
                    max3x3[2][1] = matrix[i+2][j+1];
                    max3x3[2][2] = matrix[i+2][j+2];
                }
            }
        }
        System.out.println("Sum = " + maxSum);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(max3x3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
