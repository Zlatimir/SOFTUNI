package JavaFundArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 25.9.2020 г..
 */

public class EqualSums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int index = 0;
        boolean isFound = false;
        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }
            int rightSum = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (j >= arr.length) {
                    break;
                }
                rightSum += arr[j];
            }
            if (leftSum == rightSum) {
                index = i;
                isFound = true;
            }
        }
        if (isFound){
            System.out.println(index);
        } else {
            System.out.println("no");
        }
    }
}
