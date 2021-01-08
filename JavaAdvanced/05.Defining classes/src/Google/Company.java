package Google;


/**
 * Created by Zlatimir Ivanov on 8.1.2021 г..
 */

public class Company {
    private String companyName;
    private String department;
    private double salary;

    public Company(String companyName, String department, double salary){
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        if (this.companyName.equals("")) return "";
        return String.format("%s %s %.2f%n", this.companyName, this.department, this.salary);
    }
}
