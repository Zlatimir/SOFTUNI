package bakery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zlatimir Ivanov on 13.2.2021 г..
 */

public class Bakery {
    private String name;
    private int capacity;
    private List<Employee> list;

    public Bakery(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.list = new ArrayList<>();
    }

    public void add(Employee employee){
        if (list.size() < this.capacity){
            list.add(employee);
        }
    }

    public boolean remove(String name){
        int indexToRemove = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)){
                indexToRemove = i;
                break;
            }
        }
        if (indexToRemove != -1){
            list.remove(indexToRemove);
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee(){
        Employee res = list.get(0);
        for (Employee e : list) {
            if (res.getAge() < e.getAge()){
                res = e;
            }
        }
        return res;
    }

    public Employee getEmployee(String name){
        for (Employee e : list) {
            if (e.getName().equals(name)){
                return e;
            }
        }
        return null;
    }

    public int getCount(){
        return list.size();
    }

    public String report(){
        StringBuilder res = new StringBuilder("Employees working at Bakery " + this.name + ":");
        for (Employee e : list) {
            res.append(System.lineSeparator()).append(e);
        }
        return  res.toString();
    }
}
