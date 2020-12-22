import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 21.9.2020 г..
 */

public class PokeMon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        int y = Integer.parseInt(sc.nextLine());
        int originalN = n;
        int counter = 0;
        while (n >= m) {
            counter++;
            n -= m;
            if (n * 2 == originalN) {
                if (y != 0) {
                    n /= y;
                }
            }
        }
        System.out.println(n);
        System.out.println(counter);
    }
}
