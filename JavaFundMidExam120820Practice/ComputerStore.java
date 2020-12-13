package JavaFundMidExam120820Practice;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 9.10.2020 г..
 */

public class ComputerStore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalPrice = 0;
        String input;

        while (true){
            input = sc.nextLine();
            if (input.equals("special") || input.equals("regular")){
                break;
            }
            double partPrice = Double.parseDouble(input);
            if (partPrice <=0){
                System.out.println("Invalid price!");
                continue;
            }
            totalPrice += partPrice;
        }
        double discount = 1;
        if (input.equals("special")){
            discount = 0.9;
        }
        if (totalPrice == 0){
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalPrice);
            System.out.printf("Taxes: %.2f$%n", totalPrice * 0.2);
            System.out.println("-----------");
            totalPrice *= 1.2;
            totalPrice *= discount;
            System.out.printf("Total price: %.2f$", totalPrice);
        }
    }
}
