import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 25.6.2020 г..
 */

public class CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cent = Integer.parseInt(sc.nextLine());
        int year = cent * 100;
        int days = year * 3652422 / 10000;
        int hour = days * 24;
        int min = hour * 60;
        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes", cent, year, days, hour, min);
    }
}
