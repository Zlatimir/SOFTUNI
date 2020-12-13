package JavaFundArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 26.9.2020 г..
 */

public class MagicSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int number = sc.nextInt();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == number){
                    System.out.printf("%d %d%n", arr[i], arr[j]);
                }
            }
        }
    }
}
