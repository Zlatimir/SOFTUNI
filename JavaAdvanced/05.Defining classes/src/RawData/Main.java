package RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 1.1.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[]data = sc.nextLine().split("\\s+");
            String model = data[0];
            int engSpeed = Integer.parseInt(data[1]);
            int engPower = Integer.parseInt(data[2]);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            double press1 = Double.parseDouble(data[5]);
            int age1 = Integer.parseInt(data[6]);
            double press2 = Double.parseDouble(data[7]);
            int age2 = Integer.parseInt(data[8]);
            double press3 = Double.parseDouble(data[9]);
            int age3 = Integer.parseInt(data[10]);
            double press4 = Double.parseDouble(data[11]);
            int age4 = Integer.parseInt(data[12]);

            Tire tire = new Tire(press1, age1, press2, age2, press3, age3, press4, age4);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Engine engine = new Engine(engSpeed, engPower);
            Car car = new Car(model, engine, cargo, tire);
            cars.add(car);
        }

        String line = sc.nextLine();

        if (line.equals("fragile")){
            cars.stream().filter(car -> car.getCargo().equals(line)).filter(car -> car.lessOne())
                    .forEach(car -> System.out.println(car.getModel()));
        } else {
            cars.stream().filter(car -> car.getCargo().equals(line)).filter(car -> car.power()>250)
                    .forEach(car -> System.out.println(car.getModel()));
        }
    }
}
