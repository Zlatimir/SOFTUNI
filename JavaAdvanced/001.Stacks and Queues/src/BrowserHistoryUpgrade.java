import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 18.12.2020 г..
 */

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Creating a Deque
        ArrayDeque<String> browserBack = new ArrayDeque<>();
        ArrayDeque<String> browserForward = new ArrayDeque<>();
        String input = sc.nextLine();
        String current = "";
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (!browserBack.isEmpty()) {
                    current = browserBack.pop();
                    browserForward.offer(current);
                } else {
                    System.out.println("no previous URLs");
                    input = sc.nextLine();
                    continue;
                }
            } else if (input.equals("forward")) {
                if (!browserForward.isEmpty()){
                    current = browserForward.poll();
                } else {
                    System.out.println("no next URLs");
                    input = sc.nextLine();
                    continue;
                }
            } else {
                if (!current.equals("")) {
                    browserBack.push(current);
                    browserForward.clear();
                }
                current = input;
            }
            System.out.println(current);
            input = sc.nextLine();
        }
    }
}
