import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 14.12.2020 г..
 */

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> browser = new ArrayDeque<>();
        String input = sc.nextLine();
        String current = "";
        while (!input.equals("Home")){
            if (input.equals("back")){
                if (!browser.isEmpty()){
                    current = browser.pop();
                } else {
                    System.out.println("no previous URLs");
                    input = sc.nextLine();
                    continue;
                }
            } else {
                if (!current.equals("")){
                    browser.push(current);
                }
                current = input;
            }
            System.out.println(current);
            input = sc.nextLine();
        }
    }
}
