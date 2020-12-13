package JavaFundMidExam070420Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 31.10.2020 г..
 */

public class MovingTarget {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        List<Integer> targets = new ArrayList<>(line.length);
        for (int i = 0; i < line.length; i++) {
            targets.add(Integer.parseInt(line[i]));
        }

        String input = sc.nextLine();
        while (!input.equals("End")){
            String[] commandAndParam = input.split(" ");
            String command = commandAndParam[0];
            int index = Integer.parseInt(commandAndParam[1]);
            int param = Integer.parseInt(commandAndParam[2]);
            switch (command){
                case "Shoot":
                    if (index>0 && index<targets.size()){
                        int value = targets.get(index);
                        value -= param;
                        targets.set(index, value);
                        if (targets.get(index) <= 0){
                            targets.remove(index);
                        }
                    }
                    break;
                case "Add":
                    if (index >= 0 && index < targets.size()){
                        targets.add(index, param);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int leftBound = index - param;
                    int rightBound = index + param;
                    if (leftBound < 0 || leftBound >= targets.size() || rightBound >= targets.size() || rightBound < 0){
                        System.out.println("Strike missed!");
                        break;
                    }
                    for (int i = 1; i <= param * 2 + 1; i++) {
                        targets.remove(leftBound);
                    }
                    break;
            }

            input = sc.nextLine();
        }
        for (int i = 0; i < targets.size() - 1; i++) {
            System.out.print(targets.get(i) + "|");
        }
        System.out.println(targets.get(targets.size()-1));
    }
}
