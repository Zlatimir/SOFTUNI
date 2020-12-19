import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 19.12.2020 г..
 */

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());

        int[][] input = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int[] arr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            input[i] = arr;
        }
        int[][] output = new int[rows][input[0].length];

        String[] data = sc.nextLine().split("\\s+");
        int x = Integer.parseInt(data[0]);
        int y = Integer.parseInt(data[1]);
        int wrong = input[x][y];

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                int value = input[i][j];
                if (value != wrong){
                    output[i][j] = value;
                } else {
                    value = 0;
                    if (i != 0 && input[i-1][j] != wrong){
                        value += input[i-1][j];
                    }
                    if (i != rows-1 && input[i+1][j] != wrong){
                        value += input[i+1][j];
                    }
                    if (j != 0 && input[i][j-1] != wrong){
                        value += input[i][j-1];
                    }
                    if (j != input[0].length -1 && input[i][j+1] != wrong){
                        value += input[i][j+1];
                    }
                    output[i][j] = value;
                }

                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }


    }
}
