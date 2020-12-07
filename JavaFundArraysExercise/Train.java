package JavaFundArraysExercise;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 21.9.2020 г..
 */

public class Train {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int [] train = new int[n];
        for (int i = 0; i < n; i++) {
            train[i] = Integer.parseInt(sc.nextLine());
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += train[i];
            System.out.print(train[i] + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}
