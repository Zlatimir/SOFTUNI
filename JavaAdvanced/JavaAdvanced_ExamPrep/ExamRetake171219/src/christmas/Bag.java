package christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Zlatimir Ivanov on 16.2.2021 г..
 */

public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity){
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count(){
        return this.data.size();
    }

    public void  add(Present present){
        if (this.count() < this.capacity){
            this.data.add(present);
        }
    }

    public boolean remove(String name){
        for (Present present : data) {
            if (present.getName().equals(name)) {
                this.data.remove(present);
                return true;
            }
        }
        return false;
    }

    public Present heaviestPresent(){
        Present res = this.data.get(0);
        for (Present present : data) {
            if (present.getWeight() > res.getWeight()){
                res = present;
            }
        }
        return res;
     }

     public Present getPresent(String name){
         for (Present present : data) {
             if (present.getName().equals(name)){
                 return present;
             }
         }
         return null;
     }

     public String report(){
         StringBuilder res = new StringBuilder(this.getColor() + " bag contains:");
         for (Present present : data) {
             res.append(System.lineSeparator() + present);
         }
         return res.toString();
     }
}
