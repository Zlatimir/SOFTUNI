package JavaFundExam100420Practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 1.12.2020 г..
 */

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> carMileage = new HashMap<>();
        Map<String, Integer> carFuel = new HashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] data = input.split("\\|");
            carMileage.put(data[0], Integer.parseInt(data[1]));
            carFuel.put(data[0], Integer.parseInt(data[2]));
        }
        String input = sc.nextLine();
        while (!input.equals("Stop")) {
            String[] data = input.split(" : ");
            String command = data[0];
            String car = data[1];
            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(data[2]);
                    int fuelRequired = Integer.parseInt(data[3]);
                    if (carFuel.get(car) < fuelRequired) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        carFuel.put(car, carFuel.get(car) - fuelRequired);
                        carMileage.put(car, carMileage.get(car) + distance);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuelRequired);
                        if (carMileage.get(car) > 100000) {
                            System.out.printf("Time to sell the %s!%n", car);
                            carFuel.remove(car);
                            carMileage.remove(car);
                        }
                    }
                    break;
                case "Refuel":
                    int fuel = Integer.parseInt(data[2]);
                    int currentFuel = carFuel.get(car);
                    int fuelNeeded = 75 - currentFuel;
                    if (fuelNeeded > fuel) {
                        System.out.printf("%s refueled with %d liters%n", car, fuel);
                        carFuel.put(car, fuel + currentFuel);
                    } else {
                        System.out.printf("%s refueled with %d liters%n", car, fuelNeeded);
                        carFuel.put(car, 75);
                    }
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(data[2]);
                    carMileage.put(car, carMileage.get(car) - kilometers);
                    if (carMileage.get(car) < 10000) {
                        carMileage.put(car, 10000);
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }
                    break;
            }
            input = sc.nextLine();
        }

        carMileage.entrySet().stream()
                .sorted((e1, e2) -> {
                    int result = e2.getValue().compareTo(e1.getValue());
                    if (result == 0) {
                        result = e1.getKey().compareTo(e2.getKey());
                    }
                    return result;
                })
                .forEach(e -> System.out.printf
                        ("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", e.getKey(), e.getValue(), carFuel.get(e.getKey())));
    }
}
