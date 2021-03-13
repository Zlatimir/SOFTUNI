package wildFarm;

import java.text.DecimalFormat;

/**
 * Created by Zlatimir Ivanov on 13.3.2021 г..
 */

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(food.quantity);
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %s, %d]", this.getClass().getSimpleName(), this.getAnimalName(),
                new DecimalFormat("#.##").format(this.getAnimalWeight()), this.livingRegion, this.getFoodEaten());
    }
}
