package ShoppingSpree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Zlatimir Ivanov on 27.2.2021 г..
 */

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        HashMap<String, Person> persons = new HashMap<>();
//        HashMap<String, Product> products = new HashMap<>();
//
//        String[] data = sc.nextLine().split(";");
//        for (int i = 0; i < data.length; i++) {
//            String[] tokens = data[i].split("=");
//            Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
//            persons.putIfAbsent(tokens[0], person);
//        }
//
//        data = sc.nextLine().split(";");
//        for (int i = 0; i < data.length; i++) {
//            String[] tokens = data[i].split("=");
//            Product product = new Product(tokens[0], Double.parseDouble(tokens[1]));
//            products.putIfAbsent(tokens[0], product);
//        }
//
//        String line = sc.nextLine();
//
//        while (!line.equals("END")) {
//            String[] tokens = line.split("\\s+");
//            String name = tokens[0];
//            String product = tokens[1];
//            persons.get(name).buyProduct(products.get(product));
//            line = sc.nextLine();
//        }
//
//        for (Map.Entry<String, Person> entry : persons.entrySet()) {
//            System.out.print(entry.getKey() + " - ");
//            if (entry.getValue().getProducts().isEmpty()) {
//                System.out.println("Nothing bought");
//            } else {
//                System.out.println(entry.getValue().getProducts().stream().
//                        map(Object::toString).collect(Collectors.joining(", ")));
//            }
//        }
    }
}
