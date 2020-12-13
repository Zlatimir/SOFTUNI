package JavaFundMidExam071120Compete;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 7.11.2020 г..
 */

public class SugarCubes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split("\\s+");
        List<Integer> cubes = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            cubes.add(Integer.parseInt(line[i]));
        }

        String input = sc.nextLine();
        while (!input.equals("Mort")){
            String[] commandAndParameter = input.split("\\s+");
            String command = commandAndParameter[0];
            int value = Integer.parseInt(commandAndParameter[1]);
            switch (command){
                case "Add":
                    cubes.add(value);
                    break;
                case "Remove":
                    cubes.remove(Integer.valueOf(value));
                    break;
                case "Replace":
                    int replacement = Integer.parseInt(commandAndParameter[2]);
                    int index = cubes.indexOf(value);
                    cubes.set(index, replacement);
                    break;
                case "Collapse":
                    for (int i = cubes.size() - 1; i >=0 ; i--) {
                        if (cubes.get(i) < value){
                            cubes.remove(i);
                        }
                    }
                    break;
            }
            input = sc.nextLine();
        }

        for (int i = 0; i < cubes.size() - 1; i++) {
            System.out.print(cubes.get(i) + " ");
        }
        System.out.println(cubes.get(cubes.size() - 1));
    }
}
