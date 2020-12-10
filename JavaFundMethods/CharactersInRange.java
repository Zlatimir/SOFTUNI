package JavaFundMethods;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 1.10.2020 г..
 */

public class CharactersInRange {

    private static void printCharactersBetween(char ch1, char ch2){
        char start = ch1;
        char end = ch2;
        if (ch1 > ch2){
            start = ch2;
            end = ch1;
        } else if (ch1 == ch2){
            System.out.println("No characters between");
        }
        start++;
        for (char i = start; i < end; i++) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);
        printCharactersBetween(c1, c2);
    }
}
