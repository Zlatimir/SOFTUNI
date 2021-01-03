package vetClinic;

/**
 * Created by Zlatimir Ivanov on 3.1.2021 г..
 */

public class Pet {
    private String name;
    private int age;
    private String owner;

    public Pet(String name, int age, String owner){
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getOwner() {
        return this.owner;
    }

    @Override
    public String toString() {
        return String.format("%s %d (%s)", this.name, this.age, this.owner);
    }
}
