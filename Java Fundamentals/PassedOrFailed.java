import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 24.5.2020 г..
 */
//Modify the above program, so it will print "Failed!" if the grade is lower than 3.00.
public class PassedOrFailed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double grade = Double.parseDouble(sc.nextLine());
        if (grade >= 3.) {
            System.out.println("Passed!");
        } else
            System.out.println("Failed!");

    }

}
