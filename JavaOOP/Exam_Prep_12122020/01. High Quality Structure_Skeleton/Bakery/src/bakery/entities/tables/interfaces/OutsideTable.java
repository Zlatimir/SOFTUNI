package bakery.entities.tables.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

/**
 * Created by Zlatimir Ivanov on 3.4.2021 г..
 */

public class OutsideTable extends BaseTable {
    public OutsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, 3.5);
    }


    @Override
    public String getFreeTableInfo() {
        StringBuilder result = new StringBuilder();
        result.append("Table: " + this.getTableNumber()).append(System.lineSeparator());
        result.append("Type: OutsideTable").append(System.lineSeparator());
        result.append("Capacity: " + this.getCapacity()).append(System.lineSeparator());
        result.append("Price per Person: 3.50");
        return result.toString().trim();
    }
}
