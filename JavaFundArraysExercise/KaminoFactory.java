package JavaFundArraysExercise;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 26.9.2020 г..
 */

public class KaminoFactory {

    private static int[] copyArray(int[] original, int[] copy){
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }
        return copy;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dnaLength = Integer.parseInt(sc.nextLine());
        int[] dnaSequence = new int[dnaLength];
        int[] bestSequence = new int[dnaLength];
        int maxSum = 0;
        int leftmostIndex = dnaLength - 1;
        int countOnes = 0;
        String input = sc.nextLine();
        while (!input.equals("Clone them!")){
            String[] dnaAsString = input.split("!+");
            int leftIndex = dnaLength - 1;
            int sum = 0;
            boolean firstOne = false;
            for (int i = 0; i < dnaLength - 1; i++) {
                dnaSequence[i] = Integer.parseInt(dnaAsString[i]);
                if (dnaSequence[i] == 1 && dnaSequence[i + 1] == 1){
                    if (!firstOne){
                        leftIndex = i;
                    }
                    firstOne = true;
                    sum += 1;
                }
            }

            input = sc.nextLine();
        }

    }
}
