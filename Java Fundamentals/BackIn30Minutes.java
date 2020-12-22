import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 24.5.2020 г..
 */
public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = Integer.parseInt(sc.nextLine());
        int min = Integer.parseInt(sc.nextLine());
        int newHour = hour;
        int newMin = min;
        newMin = min + 30;
        if (newMin > 59){
            newMin = newMin - 60;
            newHour = newHour + 1;
            if (newHour > 23) newHour = newHour - 24;
        }
        System.out.printf("%d:%02d",newHour, newMin);
    }
}
