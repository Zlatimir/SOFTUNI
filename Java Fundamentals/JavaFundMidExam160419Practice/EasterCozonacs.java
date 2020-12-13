package JavaFundMidExam160419Practice;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 5.11.2020 г..
 */

public class EasterCozonacs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double budget = Double.parseDouble(sc.nextLine());
        double priceKgFloor = Double.parseDouble(sc.nextLine());

        double priceEggs = 0.75 * priceKgFloor;
        double priceMilk = (priceKgFloor * 1.25) / 4;
        double totalPriceCozonac = priceEggs + priceKgFloor + priceMilk;
        int countCozonacs = 0;
        int coloredEggs = 0;

        while (budget >= totalPriceCozonac) {
            countCozonacs++;
            budget -= totalPriceCozonac;
            coloredEggs += 3;
            if (countCozonacs % 3 == 0) {
                coloredEggs = coloredEggs - (countCozonacs - 2);
            }
        }

        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.", countCozonacs, coloredEggs, budget);
    }
}
