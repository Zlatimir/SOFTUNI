package JavaFundMethods;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 1.10.2020 г..
 */

public class TopNumber {

    private static boolean isTopInteger(int n){
        boolean isTopInteger = true;
        int oneOddDigit = 0; 
        int sumDigits = 0;
        String numberAsString = n + "";
        for (int i = 0; i < numberAsString.length(); i++) {
            sumDigits += numberAsString.charAt(i) - 48;
            if ((numberAsString.charAt(i)-48)%2==1){
                oneOddDigit = 1;
            }
        }
        if (sumDigits%8 != 0){
            isTopInteger = false;
        }
        if (oneOddDigit == 0){
            isTopInteger = false;
        }
        return isTopInteger;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            if (isTopInteger(i)){
                System.out.println(i);
            }
        }
    }
}
