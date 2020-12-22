import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 24.5.2020 г..
 */
public class MultiplicationTable20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());
        if (m>10){
            System.out.printf("%d X %d = %d%n",n, m, n*m);
        }
        for (int i = m; i <=10; i++) {
            System.out.printf("%d X %d = %d%n",n, i, n*i);
        }
    }
}
