package Lab_CarInfo;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 1.1.2021 г..
 */

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = sc.nextLine().split("\\s+");
            Car car = new Car(data[0], data[1], Integer.parseInt(data[2]));
            car.carInfo();
        }
    }
}
