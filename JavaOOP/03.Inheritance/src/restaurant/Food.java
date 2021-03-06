package restaurant;

import java.math.BigDecimal;

/**
 * Created by Zlatimir Ivanov on 6.3.2021 г..
 */

public class Food extends Product {
    private double grams;

    public Food(String name, BigDecimal price, double grams) {
        super(name, price);
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }
}
