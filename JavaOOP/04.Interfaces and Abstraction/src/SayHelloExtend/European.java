package SayHelloExtend;

/**
 * Created by Zlatimir Ivanov on 7.3.2021 г..
 */

public class European extends BasePerson {
    private String name;

    public European(String name) {
        super(name);
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
