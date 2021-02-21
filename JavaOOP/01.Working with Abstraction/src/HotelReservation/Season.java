package HotelReservation;

/**
 * Created by Zlatimir Ivanov on 21.2.2021 г..
 */

public enum Season {
    AUTUMN(1),
    SPRING(2),
    WINTER(3),
    SUMMER(4);

    private int multiplier;

    Season(int multiplier){
        this.multiplier = multiplier;
    }

    public int getValue() {
        return multiplier;
    }
}
