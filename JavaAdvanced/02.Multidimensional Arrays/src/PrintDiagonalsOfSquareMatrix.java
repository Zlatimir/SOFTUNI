import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 19.12.2020 г..
 */

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(matrix[n-1-i][i] + " ");
        }
    }
}
