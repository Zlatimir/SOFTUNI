package aquarium.entities.decorations;

/**
 * Created by Zlatimir Ivanov on 10.4.2021 г..
 */

public abstract class BaseDecoration implements Decoration {
    private int comfort;
    private double price;

    protected BaseDecoration(int comfort, double price) {
        this.comfort = comfort;
        this.price = price;
    }

    @Override
    public int getComfort() {
        return this.comfort;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
