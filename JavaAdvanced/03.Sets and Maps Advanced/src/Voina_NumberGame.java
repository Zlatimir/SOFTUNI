import java.util.*;

/**
 * Created by Zlatimir Ivanov on 25.12.2020 г..
 */

public class Voina_NumberGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Integer> firstDeck = new LinkedHashSet<>();
        Set<Integer> secondDeck = new LinkedHashSet<>();

        String[] input = scan.nextLine().split("\\s+");
        for (int i = 0; i < input.length; i++) {
            firstDeck.add(Integer.parseInt(input[i]));
        }

/*
    Set<Integer> secondDeck = Arrays.stream(scan.nextLine().split("\\s+")
                                .map(Integer::parseInt)
                                .collect(Collectors.toCollection(LinkedHashSet::new));
 */
        input = scan.nextLine().split("\\s+");
        for (int i = 0; i < input.length; i++) {
            secondDeck.add(Integer.parseInt(input[i]));
        }


        for (int i = 0; i < 50; i++) {
            int firstCard = firstDeck.iterator().next();
            firstDeck.remove(firstCard);
            int secondCard = secondDeck.iterator().next();
            secondDeck.remove(secondCard);

            if (firstCard > secondCard) {
                firstDeck.add(firstCard);
                firstDeck.add(secondCard);
            } else if (secondCard > firstCard) {
                secondDeck.add(firstCard);
                secondDeck.add(secondCard);
            } else {
                firstDeck.add(firstCard);
                secondDeck.add(secondCard);
            }
            if (firstDeck.size() == 0 || secondDeck.size() == 0) break;

        }
            if (firstDeck.size() > secondDeck.size()) {
                System.out.println("First player win!");
            } else if (secondDeck.size() > firstDeck.size()) {
                System.out.println("Second player win!");
            } else {
                System.out.println("Draw!");
            }
        }
    }

