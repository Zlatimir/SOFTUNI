package CardRank;

import CardRank.*;

/**
 * Created by Zlatimir Ivanov on 21.2.2021 г..
 */

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Ranks:");
        for(CardRank.Cards card : CardRank.Cards.values()){
            System.out.println("Ordinal value: " + card.ordinal()
                    + "; Name value: " + card);
        }
    }
}
