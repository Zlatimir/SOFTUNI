package SayHelloExtend;

/**
 * Created by Zlatimir Ivanov on 7.3.2021 г..
 */

public abstract class BasePerson implements Person{
    private String name;

    protected BasePerson(String name) {
        setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
