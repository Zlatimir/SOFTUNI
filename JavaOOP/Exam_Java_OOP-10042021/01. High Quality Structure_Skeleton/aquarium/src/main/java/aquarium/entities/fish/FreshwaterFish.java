package aquarium.entities.fish;

/**
 * Created by Zlatimir Ivanov on 10.4.2021 г..
 */

public class FreshwaterFish extends BaseFish {
    private int size;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        this.size = 3;
    }

    @Override
    public void eat() {
        this.size += 3;
    }
}
