package bakery.entities.drinks.interfaces;

/**
 * Created by Zlatimir Ivanov on 3.4.2021 г..
 */

public class Water extends BaseDrink {
    public Water(String name, int portion, String brand) {
        super(name, portion, 1.5, brand);
    }


}
