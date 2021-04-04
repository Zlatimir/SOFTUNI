package bakery.repositories.interfaces;

import bakery.entities.drinks.interfaces.Drink;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Zlatimir Ivanov on 3.4.2021 г..
 */

public class DrinkRepositoryImpl implements DrinkRepository<Drink> {
    private List<Drink> drinks;

    public DrinkRepositoryImpl() {
        this.drinks = new ArrayList<>();
    }
    @Override
    public Drink getByNameAndBrand(String drinkName, String drinkBrand) {
        for (Drink drink : drinks) {
            if (drink.getBrand().equals(drinkBrand) && drink.getName().equals(drinkName)) {
                return drink;
            }
        }
        return null;
    }

    @Override
    public Collection getAll() {
        return Collections.unmodifiableList(drinks);
    }

    @Override
    public void add(Drink drink) {
        drinks.add(drink);
    }

}
