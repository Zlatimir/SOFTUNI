package rabbits;

/**
 * Created by Zlatimir Ivanov on 21.1.2021 г..
 */

public class Rabbit {
    private String name;
    private String species;
    private boolean available;

    public Rabbit(String name, String species){
        this.name = name;
        this.species = species;
        this.available = true;
    }

    public String getName(){
        return this.name;
    }

    public String getSpecies(){
        return this.species;
    }

    public boolean isAvailable(){
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        //"Rabbit ({species}): {name}"
        return String.format("Rabbit (%s): %s", this.species, this.name);
    }


}
