package wildFarm;

/**
 * Created by Zlatimir Ivanov on 13.3.2021 г..
 */

public class Zebra extends Mammal {

    public Zebra(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            super.eat(food);
        } else {
            throw new IllegalArgumentException(this.getClass().getSimpleName() + this.notEatingMessage());
        }
    }
}
