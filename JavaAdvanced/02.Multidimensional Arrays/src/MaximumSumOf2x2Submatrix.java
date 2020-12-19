import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 19.12.2020 г..
 */

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dim = sc.nextLine().split(", ");
        int rows = Integer.parseInt(dim[0]);
        int cols = Integer.parseInt(dim[1]);

        int[][] inputArr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            inputArr[i] = arr;
        }

        int maxSum = Integer.MIN_VALUE;
        int[][] maxArr = new int[2][2];

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                int sum = inputArr[i][j] + inputArr[i][j + 1] + inputArr[i + 1][j] + inputArr[i + 1][j + 1];
                if (sum > maxSum){
                    maxSum = sum;
                    maxArr[0][0] = inputArr[i][j];
                    maxArr[0][1] = inputArr[i][j + 1];
                    maxArr[1][0] = inputArr[i + 1][j];
                    maxArr[1][1] = inputArr[i + 1][j + 1];
                }
            }
        }

        System.out.println(maxArr[0][0] + " " + maxArr[0][1]);
        System.out.println(maxArr[1][0] + " " + maxArr[1][1]);
        System.out.println(maxSum);
    }
}
