package PizzaCalories;

import java.util.List;

/**
 * Created by Zlatimir Ivanov on 2.3.2021 г..
 */

public class Pizza {
//-	name: String
//-	dought:  Dough
//-	toppings: List<Topping>
//+ 	Piza (String, int numberOfToppings)
//-	setToppings(int) : void
//-	setName(String) : void
//+	setDough(Dough) : void
//+	getName(): String
//+	addTopping (Topping) : void
//+	getOverallCalories () : double

    private String name;
    private Dough dough;
    private int numberOfToppings;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);

    }

    private void setName(String name) {
        if (name.length() > 15 || name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    public void addTopping(Topping topping) {
        for (int i = 0; i < this.numberOfToppings; i++) {
            toppings.add(topping);
        }
    }

    public double getOverallCalories() {
        double calories = this.dough.calculateCalories();
        for (Topping topping : toppings) {
            calories += topping.calculateCalories();
        }
        return calories;
    }
}
