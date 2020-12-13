package JavaFundExam090820Practice;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 2.12.2020 г..
 */

public class WorldTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tour = sc.nextLine();

        String input = sc.nextLine();
        while (!input.equals("Travel")){
            String[] data = input.split(":");
            String command = data[0];
            switch (command){
                case "Add Stop":
                    int index = Integer.parseInt(data[1]);
                    String newStop = data[2];
                    if (index >=0 && index < tour.length()){
                        tour = tour.substring(0, index) + newStop + tour.substring(index);
                    }
                    System.out.println(tour);
                    break;
                case "Remove Stop":
                    int start = Integer.parseInt(data[1]);
                    int end = Integer.parseInt(data[2]);
                    if (start >= 0 && start < tour.length() && end >= 0 && end < tour.length() && start <= end){
                        String newTour = tour.substring(0, start);
                        String newTour1 = "";
                        if (end < tour.length() - 1){
                            newTour1 = tour.substring(end + 1, tour.length());
                        }
                        tour = newTour + newTour1;
                    }
                    System.out.println(tour);
                    break;
                case "Switch":
                    String oldString = data[1];
                    String newString = data[2];
                    if (tour.contains(oldString)){
                        tour = tour.replaceAll(oldString, newString);
                    }
                    System.out.println(tour);
                    break;
            }
            input = sc.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + tour);
    }
}
