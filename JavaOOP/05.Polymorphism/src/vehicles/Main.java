package vehicles;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 10.3.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] tokens = sc.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
        tokens = sc.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));

        int n = Integer.parseInt(sc.nextLine());

        while(n-- > 0) {
            tokens = sc.nextLine().split("\\s+");
            String command = tokens[0];
            String vehicle = tokens[1];
            double amount = Double.parseDouble(tokens[2]);

            switch (command) {
                case "Drive":
                    System.out.println(tryDrive(car, truck, vehicle, amount));
                    break;
                case "Refuel":
                    refuel(car, truck, vehicle, amount);
                    break;
            }
        }

        System.out.printf("Car: %.2f%n", car.fuelQuantity);
        System.out.printf("Truck: %.2f", truck.fuelQuantity);
    }

    private static String tryDrive(Vehicle car, Vehicle truck, String vehicle, double amount) {
        String res = "";
        String output = new DecimalFormat("#.##").format(amount);
        switch (vehicle) {
            case "Car":
                res = car.drive(amount) ? "Car travelled %s km" : "Car needs refueling";
                break;
            case "Truck":
                res = truck.drive(amount) ? "Truck travelled %s km" : "Truck needs refueling";
                break;
        }
        return String.format(res, output);
    }

    private static void refuel(Vehicle car, Vehicle truck, String vehicle, double amount) {
        switch (vehicle) {
            case "Car":
                car.refuel(amount);
                break;
            case "Truck":
                truck.refuel(amount);
                break;
        }
    }
}
