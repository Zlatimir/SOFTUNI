package bakery.entities.bakedFoods.interfaces;

import static bakery.common.ExceptionMessages.*;

/**
 * Created by Zlatimir Ivanov on 3.4.2021 г..
 */

public abstract class BaseFood implements BakedFood{
    private String name;
    private double portion;
    private double price;
    //protected double initialBreadPortion;

    protected BaseFood(String name, double portion, double price) {
        this.setName(name);
        this.portion = portion;
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public void setName(String name) {
        if(name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    public void setPortion(double portion) {
        if (portion <= 0) {
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2fg - %.2f", this.name, this.portion, this.price);
    }
}
