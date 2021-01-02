package CarSalesman;

import java.util.*;

/**
 * Created by Zlatimir Ivanov on 2.1.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Engine> engines = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine());
        //read engines
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split("\\s+");
            String model = data[0];
            String power = data[1];
            Engine engine = new Engine(model, power);

            if (data.length == 3) {
                try {
                    Double.parseDouble(data[2]);
                    String displacement = data[2];
                    engine.setDisplacement(displacement);
                } catch (NumberFormatException e) {
                    String efficiency = data[2];
                    engine.setEfficiency(efficiency);
                }
            } else if(data.length == 4){
                String displacement = data[2];
                String efficiency = data[3];
                engine.setDisplacement(displacement);
                engine.setEfficiency(efficiency);
            }
            engines.putIfAbsent(model, engine);
        }
        //read cars
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split("\\s+");
            String carModel = data[0];
            String carEngine = data[1];
            Car car = new Car(carModel, engines.get(carEngine));

            if (data.length == 3){
                try {
                    Double.parseDouble(data[2]);
                    String weight = data[2];
                    car.setWeight(weight);
                } catch (NumberFormatException e){
                    String color = data[2];
                    car.setColor(color);
                }
            } else if(data.length == 4){
                String weight = data[2];
                String color = data[3];
                car.setWeight(weight);
                car.setColor(color);
            }
            cars.add(car);
        }

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
