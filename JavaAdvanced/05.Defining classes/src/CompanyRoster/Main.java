package CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Zlatimir Ivanov on 1.1.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Department> departments = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            String[] data = sc.nextLine().split("\\s+");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            Employee employee = new Employee(name, salary, position, department);

            if (data.length == 5){
                if (data[4].contains("@")){
                    String email = data[4];
                    employee.setEmail(email);
                } else {
                    int age = Integer.parseInt(data[4]);
                    employee.setAge(age);
                }
            } else if (data.length == 6){
                String email = data[4];
                int age = Integer.parseInt(data[5]);
                employee.setEmail(email);
                employee.setAge(age);
            }

            employees.add(employee);
        }

        List<String> departmentsList = employees.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());

        for (String s : departmentsList) {
            departments.add(new Department(s, employees.stream()
                    .filter(employee -> employee.getDepartment().equals(s)).collect(Collectors.toList())));
        }

        departments.sort(Comparator.comparingDouble(Department::getAvgSalary).reversed());

        Department department = departments.get(0);

        department.getEmployee().sort(Comparator.comparingDouble(Employee::getSalary).reversed());

        System.out.printf("Highest Average Salary: %s%n", department.getName());

        for (Employee employee : department.getEmployee()) {
            System.out.printf("%s %.2f %s %d%n",
                    employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
        }
    }
}
