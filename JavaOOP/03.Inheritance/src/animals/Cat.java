package animals;

/**
 * Created by Zlatimir Ivanov on 4.3.2021 г..
 */

public class Cat extends Animal {
    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Meow meow";
    }
}
