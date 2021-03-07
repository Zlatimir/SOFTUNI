package InterfacePerson;

import MultipleImplementation.Birthable;
import MultipleImplementation.Identifiable;

/**
 * Created by Zlatimir Ivanov on 7.3.2021 г..
 */

public class Citizen implements Person {
    private String name;
    private int age;

    public Citizen(String name, int age) {
        this.name = name;
        this.age = age;

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getAge() {
        return this.age;
    }






}
