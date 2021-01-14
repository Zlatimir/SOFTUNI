package GenericSwapMethodStrings;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 14.1.2021 г..
 */

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int n = Integer.parseInt(sc.nextLine());

        Box[] arr = new Box[n];
        for (int i = 0; i < n; i++) {
            Box box = new Box(sc.nextLine());

            arr[i] = box;
        }

        String[] indeces = sc.nextLine().split("\\s+");
        int first = Integer.parseInt(indeces[0]);
        int second = Integer.parseInt(indeces[1]);

        Box temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;

        for (Box box : arr) {
            System.out.println(box);
        }
    }
}
