package onlineShop.models.products.components;

/**
 * Created by Zlatimir Ivanov on 9.4.2021 г..
 */

public class RandomAccessMemory extends BaseComponent {
    private static double multiplier = 1.20;

    public RandomAccessMemory(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance * multiplier, generation);
    }
}
