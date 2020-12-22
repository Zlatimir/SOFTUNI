import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 20.9.2020 г..
 */

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a1 = Integer.parseInt(sc.nextLine());
        int a2 = Integer.parseInt(sc.nextLine());
        int a3 = Integer.parseInt(sc.nextLine());
        int a4 = Integer.parseInt(sc.nextLine());
        System.out.println(((a1+a2)/a3)*a4);
    }
}
