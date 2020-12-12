package JavaFundMidExam050720Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 25.10.2020 г..
 */

public class Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int[] input = new int[line.length];
        double average;
        double sum = 0;
        for (int i = 0; i < line.length; i++) {
            input[i] = Integer.parseInt(line[i]);
            sum += input[i];
        }
        average = sum / input.length;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i] > average){
                list.add(input[i]);
            }
        }
        Collections.sort(list);
        Collections.reverse(list);

        if (list.size() == 0){
            System.out.println("No");
        } else if (list.size() > 5){
            for (int i = 0; i < 5; i++) {
                System.out.print(list.get(i) + " ");
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
        }
    }
}
