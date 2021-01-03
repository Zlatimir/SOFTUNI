package vetClinic;

import java.util.ArrayList;

/**
 * Created by Zlatimir Ivanov on 3.1.2021 г..
 */

public class Clinic {
    private int capacity;
    private ArrayList<Pet> data;

    public Clinic(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if (this.data.size() < this.capacity){
            this.data.add(pet);
        }
    }

    public boolean remove(String name){
        for (Pet pet : data) {
            if (pet.getName().equals(name)){
                this.data.remove(pet);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner){
        Pet result = null;
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)){
                result = pet;
            }
        }
        return result;
    }

    public Pet getOldestPet(){
        Pet result = null;
        for (Pet pet : data) {
            if (result == null || result.getAge() < pet.getAge()){
                result = pet;
            }
        }
        return result;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder out = new StringBuilder();
        out.append(String.format("The clinic has the following patients:%n"));
        for (Pet pet : data) {
            out.append(String.format("%s %s%n", pet.getName(), pet.getOwner()));
        }

        return out.toString().trim();
    }
}
