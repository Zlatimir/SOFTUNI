import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 17.5.2020 г..
 */
// Read three real numbers and sort them in descending order. Print each number on a new line.
public class SortNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        int c = Integer.parseInt(sc.nextLine());
        int temp = a;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        if (a < c) {
            temp = a;
            a = c;
            c = temp;
        }
        if (b < c) {
            temp = b;
            b = c;
            c = temp;
        }
        System.out.printf("%d%n%d%n%d", a, b, c);
    }
}
