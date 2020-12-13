package JavaFundMethods;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 1.10.2020 г..
 */

public class PasswordValidator {

    private static boolean countLetters(String s){
        boolean isValid = true;
        if(s.length()<6 || s.length()>10){
            isValid = false;
        }
        return isValid;
    }

    private static boolean countDigits(String s){
        boolean isValid = true;
        int digitsCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)){
                digitsCount++;
            }
        }
        if (digitsCount<2){
            isValid = false;
        }
        return isValid;
    }

    private static boolean lettersAndDigits(String s){
        boolean isValid = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!Character.isDigit(ch) && !Character.isLetter(ch)){
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        int rule = 0;
        if (!countLetters(password)){
            System.out.println("Password must be between 6 and 10 characters");
        } else {
            rule++;
        }
        if (!lettersAndDigits(password)){
            System.out.println("Password must consist only of letters and digits");
        } else {
            rule++;
        }
        if (!countDigits(password)){
            System.out.println("Password must have at least 2 digits");
        } else {
            rule++;
        }
        if (rule == 3){
            System.out.println("Password is valid");
        }
    }

}
