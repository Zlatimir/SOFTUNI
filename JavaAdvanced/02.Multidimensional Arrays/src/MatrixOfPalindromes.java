import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 19.12.2020 г..
 */

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split("\\s+");
        int rows = Integer.parseInt(data[0]);
        int cols = Integer.parseInt(data[1]);

        String[][] matrix = new String[rows][cols];

        for (char i = 0; i < rows ; i++) {
            for (char j = 0; j < cols; j++) {
                int x = 'a' + i;
                int y = 'a' + i + j;
                matrix[i][j] = Character.toString((char)x) + Character.toString((char)y) + Character.toString((char)x);
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
