import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 20.12.2020 г..
 */

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }

        int sumPrimary = 0;
        int sumSecondary = 0;
        for (int i = 0; i < n; i++) {
                sumPrimary+=matrix[i][i];
                sumSecondary+=matrix[n-1-i][i];
        }

        System.out.println(Math.abs(sumSecondary - sumPrimary));
    }
}
