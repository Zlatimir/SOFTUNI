package CardSuit;

/**
 * Created by Zlatimir Ivanov on 21.2.2021 г..
 */

public enum Cards {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);

    private int value;

    Cards(int value){
        this.value = value;
    }
}
