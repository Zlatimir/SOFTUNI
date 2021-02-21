package HotelReservation;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 21.2.2021 г..
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2].toUpperCase());
        int multiplier = season.getValue();
        Discount disc = Discount.valueOf(input[3].toUpperCase());
        double discount = 1.0 - disc.getValue() / 100;


        System.out.printf("%.2f",pricePerDay * days * multiplier * discount);
    }
}
