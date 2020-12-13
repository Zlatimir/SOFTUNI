package JavaFundArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 22.9.2020 г..
 */

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rotations = Integer.parseInt(sc.nextLine());
        int sizeArr = arr.length;
        rotations = rotations % sizeArr;
        int[] arr2 = new int[sizeArr];
        for (int i = 0; i < sizeArr; i++) {
            int j = i - rotations;
            if (j < 0){
                j += sizeArr;
            }
            arr2[j] = arr[i];
        }
        for (int i = 0; i < sizeArr; i++) {
            System.out.printf("%d ",arr2[i]);
        }
    }
}
