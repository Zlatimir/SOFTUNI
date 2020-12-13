package JavaFundMapsLambdaAndStreamApi;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 12.11.2020 г..
 */

public class Orders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> productPrice = new LinkedHashMap<>();
        Map<String, Integer> productCount = new LinkedHashMap<>();
        Map<String, Double> totalPrice = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("buy")) {
            String[] data = input.split(" ");
            String product = data[0];
            double price = Double.parseDouble(data[1]);
            int count = Integer.parseInt(data[2]);

            productPrice.put(product, price);
            if (productCount.get(product) == null) {
                    productCount.put(product, count);
            } else {
                productCount.put(product, count + productCount.get(product));
            }
            totalPrice.put(product, productPrice.get(product) * productCount.get(product));
            input = sc.nextLine();
        }

        for (Map.Entry<String, Double> entry : totalPrice.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
        }
    }
}
