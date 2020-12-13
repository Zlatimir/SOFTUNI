package JavaFundMethods;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 1.10.2020 г..
 */

public class MiddleCharacters {

    private static void middleChars(String s){
        if (s.length()%2 == 1){
            System.out.println(s.charAt(s.length()/2));
        } else {
            System.out.printf("%c%c",(s.charAt(s.length()/2-1)), s.charAt(s.length()/2));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        middleChars(s);
    }
}
