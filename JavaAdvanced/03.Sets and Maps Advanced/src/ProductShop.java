import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Zlatimir Ivanov on 25.12.2020 г..
 */

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Map<String, Double>> shops = new TreeMap<>();

        String input = scan.nextLine();
        while (!input.equals("Revision")){
            String[] data = input.split(", ");
            String name = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            if (!shops.containsKey(name)){
                shops.put(name, new LinkedHashMap<>());
            }
            shops.get(name).put(product, price);

            input = scan.nextLine();
        }

        shops.entrySet().stream().forEach(e -> {
            System.out.println(e.getKey()+"->");
            e.getValue().entrySet().stream().forEach(p -> System.out.printf("Product: %s, Price: %.1f%n",
                    p.getKey(), p.getValue()));
        });

    }
}
