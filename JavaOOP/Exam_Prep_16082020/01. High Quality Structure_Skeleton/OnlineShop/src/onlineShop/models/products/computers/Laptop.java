package onlineShop.models.products.computers;

/**
 * Created by Zlatimir Ivanov on 9.4.2021 г..
 */

public class Laptop extends BaseComputer {

    public Laptop(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, 10);
    }
}
