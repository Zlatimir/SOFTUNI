package JavaFundMidExam101219Practice;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 30.10.2020 г..
 */

public class DisneylandJourney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double journeyCost = Double.parseDouble(sc.nextLine());
        int months = Integer.parseInt(sc.nextLine());

        double moneySave = 0.0;
        for (int i = 1; i <= months ; i++) {
            if (i%2 != 0 && i != 1){
                moneySave -= moneySave * 16 / 100;
            }
            if (i%4 == 0){
                moneySave += moneySave * 25 / 100;
            }
            moneySave += journeyCost * 25 / 100;

        }
        if (moneySave >= journeyCost){
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.",
                    moneySave - journeyCost);
        } else {
            System.out.printf("Sorry. You need %.2flv. more.", journeyCost - moneySave);
        }
    }
}
