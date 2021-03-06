package restaurant;

import java.math.BigDecimal;

/**
 * Created by Zlatimir Ivanov on 6.3.2021 г..
 */

public class Beverage extends Product {
    private double milliliters;

    public Beverage(String name, BigDecimal price, double milliliters) {
        super(name, price);
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }
}
