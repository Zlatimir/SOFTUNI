import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 17.5.2020 г..
 */
//Write a method that returns the English name of the last digit of a given number.
// Write a program that reads an integer and prints the returned value from this method.
public class EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        String lastDigit = name(num % 10);
        System.out.println(lastDigit);
    }

    public static String name(int n) {
        String name = "";
        switch (n) {
            case 0:
                name = "zero";
                break;
            case 1:
                name = "one";
                break;
            case 2:
                name = "two";
                break;
            case 3:
                name = "three";
                break;
            case 4:
                name = "four";
                break;
            case 5:
                name = "five";
                break;
            case 6:
                name = "six";
                break;
            case 7:
                name = "seven";
                break;
            case 8:
                name = "eight";
                break;
            case 9:
                name = "nine";
                break;
        }
        return name;
    }

}
