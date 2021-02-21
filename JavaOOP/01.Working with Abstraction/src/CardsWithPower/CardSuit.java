package CardsWithPower;

/**
 * Created by Zlatimir Ivanov on 21.2.2021 г..
 */

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int suit;

    CardSuit(int suit){
        this.suit = suit;
    }

    public int getSuit() {
        return suit;
    }
}
