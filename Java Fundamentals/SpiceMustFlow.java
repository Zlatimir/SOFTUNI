import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 21.9.2020 г..
 */

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int startYield = Integer.parseInt(sc.nextLine());
        int dayYield = startYield;
        int countDays = 0;
        int totalYield = 0;
        while (dayYield >= 100) {
            totalYield += dayYield;
            dayYield -= 10;
            if (totalYield >= 26) {
                totalYield -= 26;
            }
            countDays++;
        }
        if (totalYield >= 26) {
            totalYield -= 26;
        }
        System.out.println(countDays);
        System.out.println(totalYield);
    }
}
