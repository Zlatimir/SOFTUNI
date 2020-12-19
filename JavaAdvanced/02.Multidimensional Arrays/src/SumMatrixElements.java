import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 19.12.2020 г..
 */

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sizes = sc.nextLine().split(", ");
        int rows = Integer.parseInt(sizes[0]);
        int cols = Integer.parseInt(sizes[1]);
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }

        System.out.println(rows);
        System.out.println(cols);

        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println(sum);
    }
}
