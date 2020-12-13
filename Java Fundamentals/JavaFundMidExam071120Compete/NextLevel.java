package JavaFundMidExam071120Compete;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 7.11.2020 г..
 */

public class NextLevel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double neededExperience = Double.parseDouble(sc.nextLine());
        int countOfBattles = Integer.parseInt(sc.nextLine());
        double currentExperience = 0;
        int battles = 0;
        boolean flag = false;
        for (int i = 0; i < countOfBattles; i++) {
            double experiencePerBattle = Double.parseDouble(sc.nextLine());
            battles++;
            if (battles % 3 == 0 && battles % 15 != 0){
                experiencePerBattle = experiencePerBattle + experiencePerBattle * 15 / 100;
            }
            if (battles % 5 == 0 && battles % 15 != 0){
                experiencePerBattle = experiencePerBattle - experiencePerBattle * 10 / 100;
            }
            if (battles % 15 == 0){
                experiencePerBattle = experiencePerBattle + experiencePerBattle * 5 / 100;
            }
            currentExperience += experiencePerBattle;
            if (currentExperience >= neededExperience){
                flag = true;
                break;
            }
        }
        if (flag){
            System.out.printf("Player successfully collected his needed experience for %d battles.", battles);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.",
                    neededExperience - currentExperience);
        }
    }
}
