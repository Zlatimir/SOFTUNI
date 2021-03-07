package SayHello;

/**
 * Created by Zlatimir Ivanov on 7.3.2021 г..
 */

public class European implements Person {
    private String name;

    public European(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
