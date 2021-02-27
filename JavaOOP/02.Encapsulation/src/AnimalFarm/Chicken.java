package AnimalFarm;

/**
 * Created by Zlatimir Ivanov on 27.2.2021 г..
 */

public class Chicken {
    private String name;
    private int age;
    private double eggsPerDay;

    public Chicken(String name, int age) {
        this.setAge(age);
        this.setName(name);
        this.eggsPerDay = calculateProductPerDay();
    }

    private void setName(String name) {
        if (!name.equals(null) && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    private void setAge(int age) {
        if (age >= 0 && age <= 15) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }

    private double calculateProductPerDay() {
        if (this.age <= 5){
            this.eggsPerDay = 2.0;
        } else if (this.age <= 11){
            this.eggsPerDay = 1.0;
        } else {
            this.eggsPerDay = 0.75;
        }
        return eggsPerDay;
    }

    public double productPerDay () {
        return this.eggsPerDay;
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.%n", this.name, this.age, this.productPerDay());
    }
}
