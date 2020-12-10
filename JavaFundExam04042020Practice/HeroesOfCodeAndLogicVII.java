package JavaFundExam04042020Practice;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 26.11.2020 г..
 */

public class HeroesOfCodeAndLogicVII {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Map<String, Hero> heroes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String name = input[0];
            int hp = Integer.parseInt(input[1]);
            int mp = Integer.parseInt(input[2]);
            Hero h = new Hero(name, hp, mp);
            heroes.put(name, h);
        }

        String input = sc.nextLine();
        while (!input.equals("End")) {
            String data[] = input.split(" - ");
            String command = data[0];
            String heroName = data[1];
            switch (command) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(data[2]);
                    String spellName = data[3];
                    if (heroes.get(heroName).getMp() >= mpNeeded) {
                        heroes.get(heroName).setMp(heroes.get(heroName).getMp() - mpNeeded);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n"
                                , heroName, spellName, heroes.get(heroName).getMp());
                    } else {
                        System.out.println(heroName + " does not have enough MP to cast " + spellName + "!");
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(data[2]);
                    String attacker = data[3];
                    heroes.get(heroName).setHp(heroes.get(heroName).getHp() - damage);
                    if (heroes.get(heroName).getHp() > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n"
                                , heroName, damage, attacker, heroes.get(heroName).getHp());
                    } else {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        heroes.remove(heroName);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(data[2]);
                    int amountNeeded = amount;
                    int currentMp = heroes.get(heroName).getMp();
                    if (currentMp + amount > 200) {
                        amountNeeded = 200 - currentMp;
                    }
                    heroes.get(heroName).setMp(heroes.get(heroName).getMp() + amountNeeded);
                    System.out.printf("%s recharged for %d MP!%n", heroName, amountNeeded);
                    break;
                case "Heal":
                    amount = Integer.parseInt(data[2]);
                    amountNeeded = amount;
                    int currentHp = heroes.get(heroName).getHp();
                    if (currentHp + amount > 100) {
                        amountNeeded = 100 - currentHp;
                    }
                    heroes.get(heroName).setHp(heroes.get(heroName).getHp() + amountNeeded);
                    System.out.printf("%s healed for %d HP!%n", heroName, amountNeeded);
                    break;
            }

            input = sc.nextLine();
        }
        heroes.entrySet().stream().
                sorted((a, b) -> {
                    int result = b.getValue().getHp() - a.getValue().getHp();
                    if (result == 0) {
                        result = a.getValue().getName().compareTo(b.getValue().getName());
                    }
                    return result;
                }).
                forEach(e -> System.out.println(e.getValue()));

    }

    static class Hero {
        String name;
        int hp;
        int mp;

        public Hero(String name, int hp, int mp) {
            this.name = name;
            this.hp = hp;
            this.mp = mp;
        }

        public String getName() {
            return name;
        }

        public int getHp() {
            return hp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        @Override
        public String toString() {
            return String.format("%s%n  HP: %d%n  MP: %d", this.name, this.getHp(), this.getMp());
        }

        public int getMp() {
            return mp;
        }

        public void setMp(int mp) {
            this.mp = mp;
        }
    }


}
