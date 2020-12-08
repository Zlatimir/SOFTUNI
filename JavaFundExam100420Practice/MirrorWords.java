package JavaFundExam100420Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zlatimir Ivanov on 30.11.2020 г..
 */

public class MirrorWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> listFirstWords = new ArrayList<>();
        List<String> listSecondWords = new ArrayList<>();
        List<String> firstPair = new ArrayList<>();
        List<String> secondPair = new ArrayList<>();
        //regexr.com/5hcf6
        String regex = "([@#])(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        String line = sc.nextLine();
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            listFirstWords.add(matcher.group("first"));
            listSecondWords.add(matcher.group("second"));
        }
        if (listFirstWords.size() == 0){
            System.out.println("No word pairs found!");
            System.out.println("No mirror words!");
        } else {
            System.out.println( listFirstWords.size() + " word pairs found!");
            for (int i = 0; i < listFirstWords.size(); i++) {
                StringBuilder revers = new StringBuilder(listSecondWords.get(i));
                revers = revers.reverse();
                if (listFirstWords.get(i).equals(revers.toString())){
                    firstPair.add(listFirstWords.get(i));
                    secondPair.add(listSecondWords.get(i));
                }
            }
            if (firstPair.size() == 0){
                System.out.println("No mirror words!");
            } else {
                System.out.println("The mirror words are:");
                for (int i = 0; i < firstPair.size() - 1; i++) {
                    System.out.print(firstPair.get(i) + " <=> " + secondPair.get(i) + ", ");
                }
                System.out.println(firstPair.get(firstPair.size()-1) + " <=> " + secondPair.get(secondPair.size()-1));
            }
        }
    }


}
