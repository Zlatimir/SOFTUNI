package animals;


/**
 * Created by Zlatimir Ivanov on 4.3.2021 г..
 */

public class Dog extends Animal {
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Woof!";
    }

}
