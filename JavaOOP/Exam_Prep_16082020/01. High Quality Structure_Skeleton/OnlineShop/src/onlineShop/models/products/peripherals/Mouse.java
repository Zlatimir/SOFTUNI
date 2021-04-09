package onlineShop.models.products.peripherals;

/**
 * Created by Zlatimir Ivanov on 9.4.2021 г..
 */

public class Mouse extends BasePeripheral {
    public Mouse(int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance, connectionType);
    }
}
