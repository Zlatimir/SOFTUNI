package PizzaCalories;

/**
 * Created by Zlatimir Ivanov on 2.3.2021 г..
 */

public class Dough {
//  -	flourType: String
//  -	bakingTechnique: String
//  -	weight: double
//  + 	Dought (String, String, double)
//  -	setWeight(double): void
//  -	setFlourType(String): void
//  -	setBakingTechnique(String): void
//  +	calculateCalories (): double

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setWeight(weight);
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        if (!flourType.equals("White") && !flourType.equals("Wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }
//•	White – 1.5;
//•	Wholegrain – 1.0;
//•	Crispy – 0.9;
//•	Chewy – 1.1;
//•	Homemade – 1.0;

    public double calculateCalories() {
        double calories = 2 * this.weight;
        if (this.flourType.equals("White")) {
            calories *= 1.5;
        } else {
            calories *= 1.0;
        }
        if (this.bakingTechnique.equals("Crispy")) {
            calories *= 0.9;
        } else if (this.bakingTechnique.equals("Chewy")) {
            calories *= 1.1;
        } else {
            calories *= 1.0;
        }
        return calories;
    }
}
