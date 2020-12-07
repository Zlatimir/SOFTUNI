package JavaFundArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 22.9.2020 г..
 */

public class TopIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            boolean isBigger = false;
            for (int j = i + 1; j < size; j++) {
                if(arr[i] > arr[j]){
                    isBigger = true;
                } else {
                    isBigger = false;
                    break;
                }
            }
            if (isBigger){
                System.out.printf("%d ", arr[i]);
            }
        }
        System.out.println(arr[size - 1]);
    }
}
