package GenericBoxInteger;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 14.1.2021 г..
 */

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            Box box = new Box(Integer.parseInt(sc.nextLine()));

            System.out.println(box);
        }
    }
}
