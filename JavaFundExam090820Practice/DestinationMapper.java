package JavaFundExam090820Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zlatimir Ivanov on 2.12.2020 г..
 */

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String regex = "([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        List<String> destinations = new ArrayList<>();
        while (matcher.find()){
            destinations.add(matcher.group("destination"));
        }
        int travelPoints = 0;
        for (String s : destinations) {
            travelPoints += s.length();
        }
        System.out.println("Destinations: " + String.join(", ", destinations));
        System.out.println("Travel Points: " + travelPoints);
    }
}
