package SayHelloExtend;

/**
 * Created by Zlatimir Ivanov on 7.3.2021 г..
 */

public class Bulgarian extends BasePerson {
    private String name;

    public Bulgarian(String name) {
        super(name);
        //this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
