package CompanyRoster;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zlatimir Ivanov on 1.1.2021 г..
 */

public class Department {
    private String name;
    double avgSalary;
    private List<Employee> employee;

    public Department(String name, List<Employee> employee) {
        this.name = name;
        this.employee = employee;
        this.avgSalary = employee.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
    }

   public double getAvgSalary(){
        return avgSalary;
   }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployee() {
        return employee;
    }


}
