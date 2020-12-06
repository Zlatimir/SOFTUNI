import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 25.6.2020 г..
 */

public class TownInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String town = sc.nextLine();
        int people = Integer.parseInt(sc.nextLine());
        double area = Double.parseDouble(sc.nextLine());
        System.out.printf("Town %s has population of %d and area %.0f square km.", town, people, area);
    }
}
