package BirthdayCelebrations;

/**
 * Created by Zlatimir Ivanov on 7.3.2021 г..
 */

public class Pet implements Identifiable, Birthable {
    private String name;
    private String birthDate;

    public Pet(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String getBirthDate() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }
}
