package JavaFundArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 22.9.2020 г..
 */

public class CommonElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr1 = sc.nextLine().split(" ");
        String[] arr2 = sc.nextLine().split(" ");

        for (String x: arr2) {
            for (String y: arr1) {
                if (y.equals(x)){
                    System.out.print(y + " ");
                }
            }
        }


    }
}
