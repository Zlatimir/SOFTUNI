import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 19.12.2020 г..
 */

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        char[][] first = new char[rows][];
        char[][] second = new char[rows][];
        char[][] output = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            char[] arr = sc.nextLine().replace(" ", "").toCharArray();
            first[i] = arr;
        }
        for (int i = 0; i < rows; i++) {
            char[] arr = sc.nextLine().replace(" ", "").toCharArray();
            second[i] = arr;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (first[i][j] == second[i][j]){
                    output[i][j] = first[i][j];
                } else {
                    output[i][j] = '*';
                }
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}
