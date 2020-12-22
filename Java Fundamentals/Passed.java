import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 24.5.2020 г..
 */
//Write a program, which takes as an input a grade and prints "Passed!" if the grade is equal or more than 3.00.
public class Passed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double grade = Double.parseDouble(sc.nextLine());
        if (grade >= 3.) System.out.println("Passed!");
    }
}
