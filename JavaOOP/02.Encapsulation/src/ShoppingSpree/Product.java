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
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        } else {
            this.name = name;
        }
    }

    private void setCost(double cost) {
        if (cost < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        } else {
            this.cost = cost;
        }
    }

    public String getName() {
        return this.name;
    }

    public double getCost() {
        return this.cost;
    }

//    @Override
//    public String toString() {
//        return this.getName();
//    }
}
