import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Zlatimir Ivanov on 18.1.2021 г..
 */

public class DatingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //males - stack
        //females - queue

        Deque<Integer> males = new ArrayDeque<>();
        Deque<Integer> females = new ArrayDeque<>();

        String[] line = sc.nextLine().split("\\s+");
        for (int i = 0; i < line.length; i++) {
            males.push(Integer.parseInt(line[i]));
        }
        line = sc.nextLine().split("\\s+");
        for (int i = 0; i < line.length; i++) {
            females.offer(Integer.parseInt(line[i]));
        }
        int count = 0;

        while (males.size() != 0 && females.size() != 0){
            int currentMale = males.peek();
            int currentFemale = females.peek();

            if (currentFemale <= 0){
                females.poll();
                continue;
            }
            if (currentMale <= 0){
                males.pop();
                continue;
            }

            if (currentMale % 25 == 0){
                males.pop();
                males.pop();
                continue;
            }
            if (currentFemale % 25 == 0){
                females.poll();
                females.poll();
                continue;
            }

            if (currentFemale == currentMale){
                count ++;
                males.pop();
                females.poll();
            } else {
                females.poll();
                males.pop();
                males.push(currentMale - 2);
            }
        }

        System.out.println("Matches: " + count);

        System.out.print("Males left: ");
        if (males.isEmpty()){
            System.out.println("none");
        } else {
            System.out.println(males.stream().map(Object::toString).collect(Collectors.joining(", ")).toString());
        }
        System.out.print("Females left: ");
        if (females.isEmpty()){
            System.out.println("none");
        } else {
            System.out.println(females.stream().map(Object::toString).collect(Collectors.joining(", ")).toString());
        }
    }
}
