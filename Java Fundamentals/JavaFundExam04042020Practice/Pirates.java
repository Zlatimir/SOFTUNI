package JavaFundExam04042020Practice;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by Zlatimir Ivanov on 24.11.2020 г..
 */

public class Pirates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> townPopulation = new TreeMap<>();
        Map<String, Integer> townGold = new TreeMap<>();

        String input = sc.nextLine().trim();
        while (!input.equals("Sail")) {
            String[] data = input.split("\\|\\|");
            String townName = data[0];
            int population = Integer.parseInt(data[1]);
            int gold = Integer.parseInt(data[2]);
            if (townPopulation.containsKey(townName)) {
                townPopulation.put(townName, townPopulation.get(townName) + population);
            } else {
                townPopulation.put(townName, population);
            }
            if (townGold.containsKey(townName)) {
                townGold.put(townName, townGold.get(townName) + gold);
            } else {
                townGold.put(townName, gold);
            }
            input = sc.nextLine().trim();
        }

        input = sc.nextLine().trim();
        while (!input.equals("End")) {
            String[] data = input.split("=>");
            String command = data[0];
            String town = data[1];
            if (command.equals("Prosper")) {
                int gold = Integer.parseInt(data[2]);
                if (gold < 0) {
                    System.out.println("Gold added cannot be a negative number!");
                    input = sc.nextLine().trim();
                    continue;
                }
                townGold.put(town, townGold.get(town) + gold);
                System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", gold, town, townGold.get(town));
            } else {
                int killed = Integer.parseInt(data[2]);
                int gold = Integer.parseInt(data[3]);
                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", town, gold, killed);
                townGold.put(town, townGold.get(town) - gold);
                townPopulation.put(town, townPopulation.get(town) - killed);
                if (townGold.get(town) == 0 || townPopulation.get(town) == 0) {
                    System.out.printf("%s has been wiped off the map!%n", town);
                    townPopulation.remove(town);
                    townGold.remove(town);
                }
            }
            input = sc.nextLine().trim();
        }

        if (townGold.size() != 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", townGold.size());
            townGold.entrySet().stream()
                    .sorted((e1, e2) -> {
                        int result = e2.getValue().compareTo(e1.getValue());
                        if (result == 0) {
                            result = e1.getKey().compareTo(e2.getKey());
                        }
                            return result;

                    })
                    .forEach(e -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",
                            e.getKey(), townPopulation.get(e.getKey()), e.getValue()));

        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }

        //townGold.entrySet().stream().sorted((e1,e2)-> e2.getValue().compareTo(e1.getValue()))
        //        .forEach(e -> System.out.println(e.getKey() + "--" + e.getValue()));
    }
}
