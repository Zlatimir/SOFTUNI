package dealership;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zlatimir Ivanov on 20.2.2021 г..
 */

public class Dealership {
    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if (this.data.size() < this.capacity){
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model){
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar(){
        Car res = this.data.get(0);
        for (Car car : data) {
            if (car.getYear() > res.getYear()){
                res = car;
            }
        }
        return res;
    }

    public Car getCar(String manufacturer, String model){
        Car res = null;
        for (Car car : data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                res = car;
            }
        }
        return res;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder res = new StringBuilder("The cars are in a car dealership " + this.name + ":");
        for (Car car : data) {
            res.append(System.lineSeparator() + car);
        }
        return res.toString();
    }
}
