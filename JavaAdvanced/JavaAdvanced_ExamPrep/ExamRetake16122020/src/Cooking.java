import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Zlatimir Ivanov on 13.2.2021 г..
 */

public class Cooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> liquidQueue = new ArrayDeque<>();
        Deque<Integer> ingredientStack = new ArrayDeque<>();

        int[] line = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < line.length; i++) {
            liquidQueue.offer(line[i]);
        }

        line = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < line.length; i++) {
            ingredientStack.push(line[i]);
        }

        int bread = 0;
        int cake = 0;
        int pastry = 0;
        int fruitPie = 0;

        while (!liquidQueue.isEmpty() && !ingredientStack.isEmpty()) {
            int liquid = liquidQueue.peek();
            int ingredient = ingredientStack.peek();

            if (liquid + ingredient == 25) {
                bread++;
                liquidQueue.pop();
                ingredientStack.poll();
            } else if (liquid + ingredient == 50) {
                cake++;
                liquidQueue.pop();
                ingredientStack.poll();
            } else if (liquid + ingredient == 75) {
                pastry++;
                liquidQueue.pop();
                ingredientStack.poll();
            } else if (liquid + ingredient == 100) {
                fruitPie++;
                liquidQueue.pop();
                ingredientStack.poll();
            } else {
                liquidQueue.pop();
                ingredientStack.poll();
                ingredientStack.push(ingredient + 3);
            }
        }

        if (bread > 0 && cake > 0 && pastry > 0 && fruitPie > 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }

        if (liquidQueue.size() == 0) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            System.out.println(liquidQueue.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }

        if (ingredientStack.size() == 0) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            System.out.println(ingredientStack.stream().map(Object::toString).collect(Collectors.joining(", ")));
        }

        System.out.println("Bread: " + bread);
        System.out.println("Cake: " + cake);
        System.out.println("Fruit Pie: " + fruitPie);
        System.out.println("Pastry: " + pastry);
    }
}
