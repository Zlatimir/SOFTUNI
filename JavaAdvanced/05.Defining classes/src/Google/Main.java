package Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 8.1.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Person> list = new HashMap<>();

        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String name = data[0];
            Person person;
            if (!list.containsKey(name)) {
                person = new Person(name);
            } else {
                person = list.get(name);
            }
            switch (data[1]) {
                case "company":
                    String company = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    person.setCompany(new Company(company, department, salary));
                    break;
                case "pokemon":
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    person.addPokemon(new Pokemon(pokemonName, pokemonType));
                    break;
                case "parents":
                    String parentName = data[2];
                    String parentBirthday = data[3];
                    person.addParent(new Parents(parentName, parentBirthday));
                    break;
                case "children":
                    String childName = data[2];
                    String childBirthday = data[3];
                    person.addChildren(new Children(childName, childBirthday));
                    break;
                case "car":
                    String model = data[2];
                    int speed = Integer.parseInt(data[3]);
                    person.setCar(new Car(model, speed));
                    break;

            }
            list.put(name, person);
            input = sc.nextLine();
        }

        input = sc.nextLine();

        if (list.containsKey(input)) {
            System.out.println(input);
            System.out.println("Company:");
            System.out.print(list.get(input).getCompany().toString());
            System.out.println("Car:");
            System.out.print(list.get(input).getCar().toString());
            System.out.println("Pokemon:");
            list.get(input).getListPokemons();
            System.out.println("Parents:");
            list.get(input).getListParents();
            System.out.println("Children:");
            list.get(input).getListChildren();
        }
    }
}
