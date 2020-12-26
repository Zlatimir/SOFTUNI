import java.util.*;

/**
 * Created by Zlatimir Ivanov on 26.12.2020 г..
 */

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Set<String>> players = new LinkedHashMap<>();
        Map<String, Integer> result = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.endsWith("JOKER")) {
            String[] nameAndCards = input.split(": ");
            String name = nameAndCards[0];
            String[] cards = nameAndCards[1].split(", ");
            players.putIfAbsent(name, new HashSet<>());
            Arrays.stream(cards).forEach(e -> players.get(name).add(e));
            input = sc.nextLine();
        }

        players.forEach((k, v) -> {
            int pow = calculate(v);
            System.out.printf("%s: %d%n", k, pow);
        });
    }

    private static int calculate(Set<String> value) {
        int power = 0;
        for (String card : value) {
            power += calculatePower(card);
        }
        return power;
    }

    private static int calculatePower(String card) {
        int pow = 0;
        int[] power = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        if (card.length() == 3) {
            pow = 10;
        } else {
            char firstLetter = card.charAt(0);
            if (Character.isDigit(firstLetter)) {
                pow += power[firstLetter - '0'];
            } else {
                switch (firstLetter) {
                    case 'J':
                        pow += 11;
                        break;
                    case 'Q':
                        pow += 12;
                        break;
                    case 'K':
                        pow += 13;
                        break;
                    case 'A':
                        pow += 14;
                        break;
                }
            }
        }
        switch (card.charAt(card.length() - 1)) {
            case 'S':
                pow *= 4;
                break;
            case 'H':
                pow *= 3;
                break;
            case 'D':
                pow *= 2;
                break;
        }
        return pow;
    }


}
