package CarShopExtend;

import java.io.Serializable;

/**
 * Created by Zlatimir Ivanov on 6.3.2021 г..
 */

public class Seat extends CarImpl implements Sellable, Serializable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;

    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String countryProduced() {
        return this.countryProduced;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s sells for %f", super.toString(), this.model, this.getPrice());
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
