import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 19.9.2020 г..
 */
public class VendingMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double money = 0.;
        while (true) {
            String input = sc.nextLine();
            if (input.equals("Start")) break;
            double coin = Double.parseDouble(input);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                money += coin;
            } else System.out.printf("Cannot accept %.2f%n", coin);
        }
        double change = money;
        double price = 0.;
        while (true) {
            String product = sc.nextLine();
            if (product.equals("End")) break;
            switch (product) {
                case "Nuts":
                    price = 2.0;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.0;
                    break;
                default:
                    System.out.println("Invalid product");
                    continue;
            }
            if (change < price) {
                System.out.println("Sorry, not enough money");
            } else {
                System.out.println("Purchased " + product);
                change -= price;
            }
        }
        System.out.printf("Change: %.2f", change);
    }
}
