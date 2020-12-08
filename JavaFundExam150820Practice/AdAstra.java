package JavaFundExam150820Practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zlatimir Ivanov on 7.12.2020 г..
 */

public class AdAstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //regexr.com/5httc
        String regex = "([#|])(?<food>[A-Z a-z\\s]+)\\1(?<date>[0-3][0-9]\\/[01][0-9]\\/[0-9][0-9])\\1(?<calories>[0-9]+)\\1";
        String input = sc.nextLine();
        Pattern pattern = Pattern.compile(regex);
        int totalCal = 0;
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            totalCal += Integer.parseInt(matcher.group("calories"));
        }

        int days = totalCal / 2000;

        System.out.println("You have food to last you for: " + days + " days!");

        matcher = pattern.matcher(input);
        while (matcher.find()) {
            System.out.printf("Item: %s, Best before: %s, Nutrition: %s%n"
                    , matcher.group("food"), matcher.group("date"), matcher.group("calories"));
        }
    }
}
