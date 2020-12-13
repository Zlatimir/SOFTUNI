package JavaFundMethods;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 1.10.2020 г..
 */

public class PalindromeIntegers {
    private static String reverseString(String s){
        String result = "";
        if (s.length() == 0){
            return result;
        }
        for (int i = s.length()-1; i >=0; i--) {
            result = result + s.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.nextLine();
            if (input.equals("END")){
                break;
            }
            if (input.equals(reverseString(input))){
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }

    }
}
