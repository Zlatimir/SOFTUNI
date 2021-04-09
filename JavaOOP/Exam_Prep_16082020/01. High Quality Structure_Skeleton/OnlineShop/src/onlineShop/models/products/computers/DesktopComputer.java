package onlineShop.models.products.computers;

/**
 * Created by Zlatimir Ivanov on 9.4.2021 г..
 */

public class DesktopComputer extends BaseComputer {

    public DesktopComputer(int id, String manufacturer, String model, double price) {
        super(id, manufacturer, model, price, 15);
    }
}
