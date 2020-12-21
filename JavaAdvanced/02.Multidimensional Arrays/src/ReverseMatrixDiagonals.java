import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 20.12.2020 г..
 */

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split("\\s+");
        final int rows = Integer.parseInt(line[0]);
        final int cols = Integer.parseInt(line[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(sc.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }

        for (int col = cols - 1; col > 0; col--) {
            int i = rows - 1;
            int j = col;
            while(i >= 0 && j < cols){
                System.out.print(matrix[i][j] + " ");
                i--;
                j++;
            }
            System.out.println();
        }

        for (int row = rows - 1; row >=0 ; row--) {
            int i = row;
            int j = 0;
            while (i >=0 && j < cols){
                System.out.print(matrix[i][j] + " ");
                i--;
                j++;
            }
            System.out.println();
        }
    }
}
