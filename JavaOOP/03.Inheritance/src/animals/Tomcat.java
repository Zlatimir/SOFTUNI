package animals;

/**
 * Created by Zlatimir Ivanov on 4.3.2021 г..
 */

public class Tomcat extends Cat {
    final static String TOMCAT_GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, TOMCAT_GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}
