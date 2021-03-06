package restaurant;

import java.math.BigDecimal;

/**
 * Created by Zlatimir Ivanov on 6.3.2021 г..
 */

public class Dessert extends Food {
    private double calories;

    public Dessert(String name, BigDecimal price, double grams, double calories) {
        super(name, price, grams);
        this.calories = calories;
    }

    public double getCalories() {
        return calories;
    }
}
