package onlineShop.models.products.peripherals;

import onlineShop.models.products.BaseProduct;

/**
 * Created by Zlatimir Ivanov on 9.4.2021 г..
 */

public abstract class BasePeripheral extends BaseProduct implements Peripheral {
    private String connectionType;

    protected BasePeripheral(int id, String manufacturer, String model, double price,
                             double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance);
        this.connectionType = connectionType;
    }

    @Override
    public String getConnectionType() {
        return this.connectionType;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Connection Type: %s", getConnectionType());
    }
}
