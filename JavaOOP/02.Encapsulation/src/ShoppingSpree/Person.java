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
    private List<Product> productList;

    public Person(String name, double money) {
        this.productList = new ArrayList<>();
        setName(name);
        setMoney(money);
    }

    private void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setMoney(double cost) {
        if (cost >= 0) {
            this.money = cost;
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public String getName() {
        return this.name;
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public void buyProduct(Product product) {
        if (this.money >= product.getCost()) {
            productList.add(product);
            System.out.printf("%s bought %s%n", this.getName(), product.getName());
            this.money -= product.getCost();
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s%n", this.getName(), product.getName()));
        }
    }
}
