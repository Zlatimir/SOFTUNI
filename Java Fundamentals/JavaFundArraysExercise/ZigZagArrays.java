package JavaFundArraysExercise;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 22.9.2020 г..
 */

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            if (i%2==0){
                arr1[i] = first;
                arr2[i] = second;
            } else {
                arr2[i] = first;
                arr1[i] = second;
            }
        }
        for (int x: arr1) {
            System.out.printf("%d ", x);
        }
        System.out.println();
        for (int x: arr2) {
            System.out.printf("%d ", x);
        }

    }
}
