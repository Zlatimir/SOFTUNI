package ListIterator;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 29.1.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        ListyIterator list = new ListyIterator();

        while (!input[0].equals("END")) {
            String command = input[0];

            switch (command) {
                case "Create":
                    for (int i = 1; i < input.length; i++) {
                        list.add(input[i]);
                    }
                    break;
                case "Move":
                    System.out.println(list.move());
                    break;
                case "Print":
                    list.print();
                    break;
                case "HasNext":
                    System.out.println(list.hasNext());
                    break;

            }

            input = sc.nextLine().split("\\s+");
        }
    }
}
