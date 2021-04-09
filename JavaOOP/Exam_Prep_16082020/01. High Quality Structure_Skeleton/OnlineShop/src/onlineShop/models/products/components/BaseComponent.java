package onlineShop.models.products.components;

import onlineShop.models.products.BaseProduct;

/**
 * Created by Zlatimir Ivanov on 9.4.2021 г..
 */

public abstract class BaseComponent extends BaseProduct implements Component  {
    private int generation;

    protected BaseComponent(int id, String manufacturer, String model, double price,
                            double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance);
        this.generation = generation;
    }

    @Override
    public int getGeneration() {
        return this.generation;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Generation: %d", getGeneration());
    }
}
