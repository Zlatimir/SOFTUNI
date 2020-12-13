package JavaFundExam090820Practice;

import java.util.*;

/**
 * Created by Zlatimir Ivanov on 2.12.2020 г..
 */

public class PlantDiscovery {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Plant> plants = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("<->");
            String plantName = input[0];
            int pantRarity = Integer.parseInt(input[1]);
            //creates new plant object with empty Rating list
            Plant p = new Plant(plantName, pantRarity, new ArrayList<>());
            plants.put(plantName, p);
        }

        String input = sc.nextLine();
        while (!input.equals("Exhibition")) {
            String[] data = input.split(": ");
            String command = data[0];
            String[] plantAndParams = data[1].split(" - ");
            String name = plantAndParams[0];

            switch (command) {
                case "Rate":
                    int newRating = Integer.parseInt(plantAndParams[1]);
                    if (plants.containsKey(name)) {
                        plants.get(name).rating.add((double) newRating);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    int newRarity = Integer.parseInt(plantAndParams[1]);
                    if (plants.containsKey(name)) {
                        plants.get(name).rarity = newRarity;
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    if (plants.containsKey(name)) {
                        plants.get(name).rating.clear();
                    } else {
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            input = sc.nextLine();
        }

        for (Map.Entry<String, Plant> entry : plants.entrySet()) {
            double sum = 0.;
            int count = entry.getValue().rating.size();
            if (count != 0) {
                for (int i = 0; i < count; i++) {
                    sum += entry.getValue().rating.get(i);
                }
                double average = sum / count;
                entry.getValue().rating.clear();
                entry.getValue().rating.add(average);
            } else {
                entry.getValue().rating.add(0.);
            }
        }

        System.out.println("Plants for the exhibition:");
        plants.entrySet().stream().sorted((a, b) -> {
           if (a.getValue().rarity != b.getValue().rarity){
               return b.getValue().rarity - a.getValue().rarity;// compares int - returns in descending order
           } else {
               return Double.compare(b.getValue().rating.get(0), a.getValue().rating.get(0));
           }
        })
        .forEach((e) -> System.out.println(e.getValue()));

        /* How to print - Joro Georgiev - 02.12.2020
        *
        * plants.values().stream()
        * .sorted((a, b) -> {
        *   if(a.getRarity() != b.getRarity()){
        *       return Integer.compare(b.getRarity(), a.getRarity());
        *      } else {
        *       return Double.compare(b.getAverageRating, a.getAverageRating);      - needs getAverageRating method
        *      }
        * })
        * .map(e -> "- " + e.getName() + "; Rarity: " + e.getRarity() + ......)      - needs getters
        * .forEach(s -> System.out.println(s));
        */
    }

    static class Plant {
        String name;
        int rarity;
        List<Double> rating;

        public Plant(String name, int rarity, List<Double> rating) {
            this.name = name;
            this.rarity = rarity;
            this.rating = rating;
        }

        @Override
        public String toString() {
            return "- " + name + "; Rarity: " + rarity + "; Rating: " + String.format(Locale.US,"%.2f", rating.get(0));
        }
    }
}
