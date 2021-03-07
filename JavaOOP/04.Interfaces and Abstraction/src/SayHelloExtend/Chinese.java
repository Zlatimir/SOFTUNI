package SayHelloExtend;

/**
 * Created by Zlatimir Ivanov on 7.3.2021 г..
 */

public class Chinese extends BasePerson {
    private String name;

    public Chinese(String name) {
        super(name);
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
