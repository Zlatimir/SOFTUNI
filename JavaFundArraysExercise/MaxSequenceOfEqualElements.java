package JavaFundArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 26.9.2020 г..
 */

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxOccurrences = 0;
        int element = 0;
        int occurrences = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                occurrences++;

                if (occurrences > maxOccurrences) {
                    maxOccurrences = occurrences;
                    element = arr[i];
                }
            } else
                occurrences = 1;
        }

        for (int i = 0; i < maxOccurrences; i++) {
            System.out.print(element + " ");
        }
    }
}