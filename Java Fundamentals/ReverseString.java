import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 17.5.2020 г..
 */
//Write a program which reverses a string and print it on the console.
public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        for (int i=input.length()-1; i>=0;i--){
            System.out.print(input.charAt(i));
        }
    }
}
