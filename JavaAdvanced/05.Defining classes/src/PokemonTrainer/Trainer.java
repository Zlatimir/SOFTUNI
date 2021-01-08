package PokemonTrainer;

import java.util.*;

/**
 * Created by Zlatimir Ivanov on 5.1.2021 г..
 */

public class Trainer {

    private String name;
    private long numberOfBadges;
    private List<Pokemon> listPokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.listPokemons = new ArrayList<>();
    }

    public long getNumberOfBadges() {
        return (int) this.numberOfBadges;
    }

    public void setNumberOfBadges(long numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public String getName() {
        return this.name;
    }

    public void decreaseHealth() {
        List<Integer> indexOfPokemonToRemove = new ArrayList<>();
        for (Pokemon pokemon : this.listPokemons) {
            pokemon.setHealth(pokemon.getHealth() - 10);
            if (pokemon.getHealth() <= 0){
                indexOfPokemonToRemove.add(this.listPokemons.indexOf(pokemon));
            }
        }
        Collections.sort(indexOfPokemonToRemove, Collections.reverseOrder());
        for (int index : indexOfPokemonToRemove) {
            this.listPokemons.remove(index);
        }
    }

    public void add(Pokemon pokemon){
        this.listPokemons.add(pokemon);
    }

    public List<Pokemon> getListPokemons() {
        return this.listPokemons;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.getNumberOfBadges(), this.listPokemons.size());
    }
}

