package bakery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zlatimir Ivanov on 13.2.2021 г..
 */

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Bakery(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee){
        if (employees.size() < this.capacity){
            employees.add(employee);
        }
    }

    public boolean remove(String name){
        int indexToRemove = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equals(name)){
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1){
            employees.remove(indexToRemove);
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee(){
        Employee res = employees.get(0);
        for (Employee e : employees) {
            if (res.getAge() < e.getAge()){
                res = e;
            }
        }
        return res;
    }

    public Employee getEmployee(String name){
        for (Employee e : employees) {
            if (e.getName().equals(name)){
                return e;
            }
        }
        return null;
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder res = new StringBuilder("Employees working at Bakery " + this.name + ":");
        for (Employee e : employees) {
            res.append(System.lineSeparator()).append(e);
        }
        return  res.toString();
    }
}
