package rabbits;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zlatimir Ivanov on 21.1.2021 г..
 */

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void add(Rabbit rabbit){
        if (this.data.size() < this.capacity){
            this.data.add(rabbit);
        }

    }

    public boolean removeRabbit(String name){
        if (this.data.remove(name)) return true;
        else return false;
    }

    public void removeSpecies(String species){
        for (Rabbit rabbit : data) {
            if (rabbit.getSpecies().equals(species)) data.remove(rabbit);
        }
    }

    public int count(){
        return this.data.size();
    }

    public Rabbit sellRabbit(String name){
        for (Rabbit rabbit : this.data) {
            if (rabbit.getName().equals(name)){
                rabbit.setAvailable(false);
                return rabbit;
            }
        }
        return null;
    }

    public List<Rabbit> sellRabbitBySpecies(String species){
        List<Rabbit> salesList = new ArrayList<>();
        for (Rabbit rabbit : this.data) {
            if (rabbit.getSpecies().equals(species)){
                rabbit.setAvailable(false);
                salesList.add(rabbit);
            }
        }
        return salesList;
    }

    public String report(){
        String result = String.format("Rabbits available at %s:%n", this.name);
        for (Rabbit rabbit : this.data) {
            if (rabbit.isAvailable()){
                result += rabbit + System.lineSeparator();
            }
        }
        return result;
    }

}
