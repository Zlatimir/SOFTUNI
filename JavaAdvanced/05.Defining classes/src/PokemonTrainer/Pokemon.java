package PokemonTrainer;

/**
 * Created by Zlatimir Ivanov on 5.1.2021 г..
 */

public class Pokemon {

    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health){
        this.name = name;
        this.element = element;
        this.health = health;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getElement() {
        return this.element;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }
}
