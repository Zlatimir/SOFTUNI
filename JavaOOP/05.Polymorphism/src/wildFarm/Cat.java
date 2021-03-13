package wildFarm;

import java.text.DecimalFormat;

/**
 * Created by Zlatimir Ivanov on 13.3.2021 г..
 */

public class Cat extends Felime {
    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %s, %d]", this.getClass().getSimpleName(), this.getAnimalName(), this.breed,
                new DecimalFormat("#.##").format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}
