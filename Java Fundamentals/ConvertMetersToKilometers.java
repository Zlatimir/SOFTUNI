import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 25.6.2020 г..
 */

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int meter = Integer.parseInt(sc.nextLine());
        System.out.printf("%.2f", meter / 1000.);
    }
}
