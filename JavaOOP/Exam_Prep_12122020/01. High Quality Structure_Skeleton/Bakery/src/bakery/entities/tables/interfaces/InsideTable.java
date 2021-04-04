package bakery.entities.tables.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;

/**
 * Created by Zlatimir Ivanov on 3.4.2021 г..
 */

public class InsideTable extends BaseTable {
    public InsideTable(int tableNumber, int capacity) {
        super(tableNumber, capacity, 2.5);
    }


    @Override
    public String getFreeTableInfo() {
        StringBuilder result = new StringBuilder();
        result.append("Table: " + this.getTableNumber()).append(System.lineSeparator());
        result.append("Type: InsideTable").append(System.lineSeparator());
        result.append("Capacity: " + this.getCapacity()).append(System.lineSeparator());
        result.append("Price per Person: 2.50");
        return result.toString().trim();
    }
}
