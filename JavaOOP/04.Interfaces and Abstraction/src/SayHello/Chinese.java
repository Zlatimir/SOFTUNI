package SayHello;

/**
 * Created by Zlatimir Ivanov on 7.3.2021 г..
 */

public class Chinese implements Person {
    private String name;

    public Chinese(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
