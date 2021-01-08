package PokemonTrainer;

import java.util.*;

/**
 * Created by Zlatimir Ivanov on 5.1.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("Tournament")) {
            String[] data = input.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer;
            if (!trainers.containsKey(trainerName)) {
                trainer = new Trainer(trainerName);
            } else {
                trainer = trainers.get(trainerName);
            }
            trainer.add(pokemon);
            trainers.putIfAbsent(trainerName, trainer);

            input = sc.nextLine();
        }

        input = sc.nextLine();
        while (!input.equals("End")) {
            String element = input;

            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
                long count = entry.getValue().getListPokemons().stream()
                        .filter(pokemon -> pokemon.getElement().equals(element)).count();
                if (count > 0) {
                    entry.getValue().setNumberOfBadges(entry.getValue().getNumberOfBadges() + 1);
                } else {
                    entry.getValue().decreaseHealth();
                }
            }
            input = sc.nextLine();
        }

        trainers.values().stream().sorted((f, s) -> {
            long res = s.getNumberOfBadges() - f.getNumberOfBadges();
            return (int) res;
        }).forEach(e -> System.out.println(e));
    }
}
