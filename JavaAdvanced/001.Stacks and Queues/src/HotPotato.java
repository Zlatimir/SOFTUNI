import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 16.12.2020 г..
 */

public class HotPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String line = sc.nextLine();
        String[] names = line.split("\\s+");
        Collections.addAll(queue, names);
        int n = Integer.parseInt(sc.nextLine());
        int count = 0;
        while (queue.size() > 1){
            count++;
            if (count == n){
                System.out.println("Removed " + queue.poll());
                count = 0;
            } else {
                queue.offer(queue.poll());
            }
        }
        System.out.println("Last is " + queue.poll());

    }
}
