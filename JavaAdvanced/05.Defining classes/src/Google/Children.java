package Google;

/**
 * Created by Zlatimir Ivanov on 8.1.2021 г..
 */

public class Children {
    private String childName;
    private String childBirthday;

    public Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.childName, this.childBirthday);
    }
}
