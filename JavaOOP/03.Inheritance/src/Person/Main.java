package Person;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 3.3.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int age = Integer.parseInt(sc.nextLine());

        Child child = new Child(name, age);

        System.out.println(child.getName());
        System.out.println(child.getAge());
    }

}
