import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 19.9.2020 г..
 */
public class Vacation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(sc.nextLine());
        String typeOfGroup = sc.nextLine();
        String dayOfWeek = sc.nextLine();
        double totalPrice = 0.0;
        double pricePersonDay = 0.0;
        int discount = 0;
        switch (typeOfGroup) {
            case "Students_lab":
                if (numberOfPeople >= 30) discount = 15;
                switch (dayOfWeek) {
                    case "Friday":
                        pricePersonDay = 8.45;
                        break;
                    case "Saturday":
                        pricePersonDay = 9.80;
                        break;
                    case "Sunday":
                        pricePersonDay = 10.46;
                        break;
                }
                break;
            case "Business":
                if (numberOfPeople >= 100) numberOfPeople = numberOfPeople - 10;
                switch (dayOfWeek) {
                    case "Friday":
                        pricePersonDay = 10.90;
                        break;
                    case "Saturday":
                        pricePersonDay = 15.60;
                        break;
                    case "Sunday":
                        pricePersonDay = 16.00;
                        break;
                }
                break;
            case "Regular":
                if (numberOfPeople >= 10 && numberOfPeople <= 20) discount = 5;
                switch (dayOfWeek) {
                    case "Friday":
                        pricePersonDay = 15.00;
                        break;
                    case "Saturday":
                        pricePersonDay = 20.00;
                        break;
                    case "Sunday":
                        pricePersonDay = 22.50;
                        break;
                }
                break;
        }
        totalPrice = numberOfPeople * pricePersonDay;
        totalPrice = totalPrice - totalPrice * discount/100;
        System.out.printf("Total price: %.2f",totalPrice);
    }
}
