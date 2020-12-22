import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 24.5.2020 г..
 */
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <=10 ; i++) {
            System.out.printf("%d X %d = %d%n", n, i, n*i);
        }
    }
}
