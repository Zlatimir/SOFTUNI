import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 24.5.2020 г..
 */
//You will be given 3 lines of input – student name, age and average grade.
//        Your task is to print all the info about the student in the following format:
//        "Name: {student name}, Age: {student age}, Grade: {student grade}".
public class StudentInformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());
        double grade = Double.parseDouble(sc.nextLine());
        System.out.printf("Name: %s, Age: %d, Grade: %.2f",name, age, grade);
    }
}
