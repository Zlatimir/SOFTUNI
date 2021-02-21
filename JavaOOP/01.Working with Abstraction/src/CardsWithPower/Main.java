package CardsWithPower;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 21.2.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String card = sc.nextLine();
        String suit = sc.nextLine();

        CardRank rank = CardRank.valueOf(card);
        CardSuit suit2 = CardSuit.valueOf(suit);

        int power = rank.getRank() + suit2.getSuit();

        System.out.printf("Card name: %s of %s; Card power: %d", card, suit, power);
    }
}
