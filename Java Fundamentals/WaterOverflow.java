import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 20.9.2020 г..
 */

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(sc.nextLine());
            if (x > (255 - sum)){
                System.out.println("Insufficient capacity!");
            } else {
                sum = sum + x;
            }
        }
        System.out.println(sum);
    }
}
