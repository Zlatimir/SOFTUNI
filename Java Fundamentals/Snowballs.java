import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 21.9.2020 г..
 */

public class Snowballs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double maxSnow = 0;
        double maxTime = 1;
        double maxQuality = 0;
        double maxValue = 0;
        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt(sc.nextLine());
            int snowballTime = Integer.parseInt(sc.nextLine());
            int snowballQuality = Integer.parseInt(sc.nextLine());
            double snowballValue = Math.pow((double)(snowballSnow / snowballTime),(double) snowballQuality);
            if (snowballValue > maxValue){
                maxQuality = (double)snowballQuality;
                maxSnow = (double)snowballSnow;
                maxTime = (double)snowballTime;
                maxValue = (double)snowballValue;
            }
        }
        System.out.printf("%.0f : %.0f = %.0f (%.0f)", maxSnow, maxTime, maxValue, maxQuality);
    }
}
