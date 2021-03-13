package wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 13.3.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Animal> animals = new ArrayList<>();
        String line = sc.nextLine();

        while (!line.equalsIgnoreCase("END")) {
            String[] animalInfo = line.split("\\s+");
            String type = animalInfo[0];
            String name = animalInfo[1];
            double weight = Double.parseDouble(animalInfo[2]);
            String region = animalInfo[3];

            Animal animal = null;
            switch (type) {
                case "Mouse":
                    animal = new Mouse(type, name, weight, region);
                    break;
                case "Zebra":
                    animal = new Zebra(type, name, weight, region);
                    break;
                case "Tiger":
                    animal = new Tiger(type, name, weight, region);
                    break;
                case "Cat":
                    String breed = animalInfo[4];
                    animal = new Cat(type, name, weight, region, breed);
                    break;
            }


            String foodInfo[] = sc.nextLine().split("\\s+");
            String foodType = foodInfo[0];
            int foodQuantity = Integer.parseInt(foodInfo[1]);

            Food food = null;
            if (foodType.equalsIgnoreCase("Meat")) {
                food = new Meat(foodQuantity);
            } else {
                food = new Vegetable(foodQuantity);
            }

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animals.add(animal);

            line = sc.nextLine();
        }

        animals.forEach(System.out::println);
    }
}
