import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 16.12.2020 г..
 */

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();
        String input = sc.nextLine();
        while (!input.equals("print")){
            if (!input.equals("cancel")){
                queue.offer(input);
            } else if (queue.isEmpty()){
                System.out.println("Printer is on standby");
            } else {
                System.out.println("Canceled " + queue.poll());
            }
            input = sc.nextLine();
        }
        while (queue.size() > 0){
            System.out.println(queue.poll());
        }
    }
}
