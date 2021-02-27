package AnimalFarm;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 27.2.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());

        Chicken chicken = new Chicken(name, age);

        System.out.println(chicken);
    }
}
