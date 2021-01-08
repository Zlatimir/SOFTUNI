package Google;

/**
 * Created by Zlatimir Ivanov on 8.1.2021 г..
 */

public class Parents {
    private String parentName;
    private String parentBirthday;

    public Parents(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.parentName, this.parentBirthday);
    }
}
