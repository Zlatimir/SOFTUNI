package ShoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zlatimir Ivanov on 27.2.2021 г..
 */

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.products = new ArrayList<>();
        setName(name);
        setMoney(money);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    private void setMoney(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else {
            this.money = cost;
        }
    }

    public String getName() {
        return this.name;
    }

//    public List<Product> getProducts() {
//        return Collections.unmodifiableList(products);
//    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            products.add(product);
            //System.out.printf("%s bought %s%n", this.getName(), product.getName());
            this.money -= product.getCost();
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s%n", this.getName(), product.getName()));
        }
    }
}
