import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 19.7.2020 г..
 */

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split(" ");

        for (int i = 0; i < str.length/2; i++) {
            String tmp = str[i];
            str[i] = str[str.length-1-i];
            str[str.length-1-i] = tmp;
        }
        for (String x: str) {
            System.out.print(x + " ");
        }
    }
}
