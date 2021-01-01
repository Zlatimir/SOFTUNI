package OpinionPoll;

/**
 * Created by Zlatimir Ivanov on 1.1.2021 г..
 */

public class Person {
    private String name;
    private int age;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
