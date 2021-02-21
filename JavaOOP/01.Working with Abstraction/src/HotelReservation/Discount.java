package HotelReservation;

/**
 * Created by Zlatimir Ivanov on 21.2.2021 г..
 */

public enum Discount {
    VIP(20),
    SECONDVISIT(10),
    NONE(0);

    private double discount;

    Discount(double discount){
        this.discount = discount;
    }

    public double getValue() {
        return discount;
    }
}
