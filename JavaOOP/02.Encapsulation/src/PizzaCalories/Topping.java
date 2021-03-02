package PizzaCalories;

/**
 * Created by Zlatimir Ivanov on 2.3.2021 г..
 */

public class Topping {
//      -	toppingType: String
//      -	weight: double
//      + 	Topping (String, double)
//      -	setToppingType (String): void
//      -	setWeight (double): void
//      +	calculateCalories (): double

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if (!toppingType.equals("Meat") && !toppingType.equals("Veggies")
                && !toppingType.equals("Cheese") && !toppingType.equals("Sauce")) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;
    }
//•	Meat – 1.2;
//•	Veggies – 0.8;
//•	Cheese – 1.1;
//•	Sauce – 0.9;

    public double calculateCalories() {
        switch (toppingType) {
            case "Meat": return 2 * weight * 1.2;
            case "Veggies": return 2 * weight * 0.8;
            case "Cheese": return 2 * weight * 1.1;
            case "Sauce": return 2 * weight * 0.9;
        }
        return 0.0;
    }
}
