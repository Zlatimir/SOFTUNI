package ShoppingSpree;

/**
 * Created by Zlatimir Ivanov on 27.2.2021 г..
 */

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    private void setName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    private void setCost(double cost) {
        if (cost >= 0) {
            this.cost = cost;
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
