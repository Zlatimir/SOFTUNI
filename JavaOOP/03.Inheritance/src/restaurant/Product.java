package restaurant;

import java.math.BigDecimal;

/**
 * Created by Zlatimir Ivanov on 6.3.2021 г..
 */

public class Product {
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
