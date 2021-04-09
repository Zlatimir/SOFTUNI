package onlineShop.models.products.components;

/**
 * Created by Zlatimir Ivanov on 9.4.2021 г..
 */

public class VideoCard extends BaseComponent {
    private static double multiplier = 1.15;

    public VideoCard(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance * multiplier, generation);
    }
}
