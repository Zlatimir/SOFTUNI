import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 19.12.2020 г..
 */

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(", ");
        int size = Integer.parseInt(data[0]);
        String pattern = data[1];
        int[][] output = new int[size][size];
        switch (pattern){
            case "A":
                output = fillA(size);
                break;
            case "B":
                output = fillB(size);
                break;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillB(int size) {
        int[][] matrix = new int[size][size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (i%2 == 0){
                for (int j = 0; j < size; j++) {
                    count++;
                    matrix[j][i] = count;
                }
            } else {
                for (int j = size-1; j >=0; j--) {
                    count++;
                    matrix[j][i] = count;
                }
            }
        }
        return matrix;
    }

    private static int[][] fillA(int size) {
        int[][] matrix = new int[size][size];
        int count = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                count++;
                matrix[j][i] = count;
            }
        }
        return matrix;
    }
}
