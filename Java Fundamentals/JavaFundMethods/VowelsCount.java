package JavaFundMethods;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 1.10.2020 г..
 */

public class VowelsCount {

    private static void vowels(String s){
        int countVowels = 0;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //vowels in english are A, E, I, O, U, and sometimes Y.
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                countVowels++;
            }
        }
        System.out.println(countVowels);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        vowels(s);
    }
}
