package SayHelloExtend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zlatimir Ivanov on 7.3.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();


        persons.add(new Bulgarian("Pesho"));
        persons.add(new European("Pesho"));
        persons.add(new Chinese("Pesho"));

        for (Person person : persons) {
            print(person);
        }
    }

    private static void print(Person person) {
        System.out.println(person.sayHello());
    }
}

