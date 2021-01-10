import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;


/**
 * Created by Zlatimir Ivanov on 10.1.2021 г..
 */

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> listWords = new ArrayList<>();
        String[] input = sc.nextLine().split("\\s+");

        Predicate<String> wordStartUpper = s -> Character.isUpperCase(s.charAt(0));

        int count = 0;
        for (String s : input) {
            if (wordStartUpper.test(s)){
                count++;
                listWords.add(s);
            }
        }

        System.out.println(count);
        for (String word : listWords) {
            System.out.println(word);
        }

    }
}
