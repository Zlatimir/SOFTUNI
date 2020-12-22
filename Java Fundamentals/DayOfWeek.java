import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 21.9.2020 г..
 */

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int day = Integer.parseInt(sc.nextLine());
        String [] daysOfWeek = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (day >=1 && day <=7){
            System.out.println(daysOfWeek[day-1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
