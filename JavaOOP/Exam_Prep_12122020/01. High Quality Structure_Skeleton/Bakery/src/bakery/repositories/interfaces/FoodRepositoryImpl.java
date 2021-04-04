package bakery.repositories.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;

import java.util.*;

/**
 * Created by Zlatimir Ivanov on 3.4.2021 г..
 */

public class FoodRepositoryImpl implements FoodRepository<BakedFood> {
    private List<BakedFood> foodList;

    public FoodRepositoryImpl() {
        this.foodList = new ArrayList<>();
    }

    @Override
    public void add(BakedFood bakedFood) {
        foodList.add(bakedFood);
    }

    @Override
    public BakedFood getByName(String name) {
        for (BakedFood food : foodList) {
            if (food.getName().equals(name)) {
                return food;
            }
        }
        return null;
    }

    @Override
    public Collection getAll() {
        return null;
    }


}
