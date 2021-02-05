import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Zlatimir Ivanov on 5.2.2021 г..
 */

public class Bombs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> bombEffectQueue = new ArrayDeque<>();
        Deque<Integer> bombCasingStack = new ArrayDeque<>();

        int[] ints = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        for (int number : ints) {
            bombEffectQueue.offer(number);
        }

        ints = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        for (int number : ints) {
            bombCasingStack.push(number);
        }

        int daturaCount = 0;
        int cherryCount = 0;
        int smokeCount = 0;
        boolean bombPouch = false;

        while (!bombEffectQueue.isEmpty() && !bombCasingStack.isEmpty()) {
            if (daturaCount >= 3 && cherryCount >= 3 && smokeCount >= 3) {
                bombPouch = true;
                break;
            }
            int effect = bombEffectQueue.peek();
            int casing = bombCasingStack.peek();

            if (effect + casing == 40) {
                daturaCount++;
                bombEffectQueue.poll();
                bombCasingStack.pop();
            } else if (effect + casing == 60) {
                cherryCount++;
                bombEffectQueue.poll();
                bombCasingStack.pop();
            } else if (effect + casing == 120) {
                smokeCount++;
                bombEffectQueue.poll();
                bombCasingStack.pop();
            } else {
                casing = casing - 5;
                bombCasingStack.pop();
                bombCasingStack.push(casing);
            }
        }

        if (bombPouch){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffectQueue.isEmpty()){
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            System.out.println(bombEffectQueue.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")).toString());
        }

        if (bombCasingStack.isEmpty()){
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            System.out.println(bombCasingStack.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")).toString());

        }

        System.out.println("Cherry Bombs: " + cherryCount);
        System.out.println("Datura Bombs: " + daturaCount);
        System.out.println("Smoke Decoy Bombs: " + smokeCount);
    }
}
