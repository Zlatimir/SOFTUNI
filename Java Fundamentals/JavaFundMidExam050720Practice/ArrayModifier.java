package JavaFundMidExam050720Practice;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 25.10.2020 г..
 */

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        long[] arr = new long[data.length];
        for (int i = 0; i < data.length; i++) {
            arr[i] = Long.parseLong(data[i]);
        }

        String input = sc.nextLine();
        while (!input.equals("end")){
            if (input.equals("decrease")){
                for (int i = 0; i < arr.length; i++) {
                    arr[i] -=1;
                }
                input = sc.nextLine();
                continue;
            }
            String[] command = input.split(" ");
            int index1 = Integer.parseInt(command[1]);
            int index2 = Integer.parseInt(command[2]);

            switch (command[0]){
                case "swap":
                    long temp = arr[index1];
                    arr[index1] = arr[index2];
                    arr[index2] = temp;
                    break;
                case  "multiply":
                    arr[index1] *= arr[index2];
                    break;
            }
            input = sc.nextLine();
        }
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1]);
    }
}
