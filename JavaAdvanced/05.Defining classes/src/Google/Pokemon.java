package Google;

/**
 * Created by Zlatimir Ivanov on 8.1.2021 г..
 */

public class Pokemon {
    private String pokemonName;
    private String pokemonType;

    public Pokemon(String pokemonName, String pokemonType){
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.pokemonName, this.pokemonType);
    }
}
