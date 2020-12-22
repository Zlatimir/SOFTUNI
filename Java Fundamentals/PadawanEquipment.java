import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 19.9.2020 г..
 */

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money = Double.parseDouble(sc.nextLine());
        int students = Integer.parseInt(sc.nextLine());
        double lightsaberPrice = Double.parseDouble(sc.nextLine());
        double robePrice = Double.parseDouble(sc.nextLine());
        double beltPrice = Double.parseDouble(sc.nextLine());
        double totalPrice = lightsaberPrice * Math.ceil(students * 1.1) + robePrice * students;
        int freeBelts = students / 6;
        totalPrice = totalPrice + beltPrice * (students - freeBelts);
        if (money >= totalPrice){
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else {
            System.out.printf("Ivan Cho will need %.2flv more.", totalPrice - money);
        }
    }
}
