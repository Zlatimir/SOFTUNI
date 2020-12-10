package JavaFundExam04042020Practice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Character.isDigit;

/**
 * Created by Zlatimir Ivanov on 21.11.2020 г..
 */

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //regexr.com/5gtdg
        Pattern pattern = Pattern.compile(("((::|\\*\\*)[A-Z][a-z][a-z]+\\2)"));
        List<String> listEmoji = new ArrayList<>();
        String input = sc.nextLine();
        BigInteger coolTreshold = computeCoolTreshold(input);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            listEmoji.add(matcher.group(1));
        }
        System.out.printf("Cool threshold: %d%n", coolTreshold);
        System.out.printf("%d emojis found in the text. The cool ones are:%n", listEmoji.size());

        for (String s : listEmoji) {
            int treshold = treshold(s);
            if (BigInteger.valueOf(treshold).compareTo(coolTreshold) >= 0) {
                System.out.println(s);
            }
        }
    }

    private static int treshold(String s) {
        s = s.substring(2, s.length() - 2);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i);
        }
        return sum;
    }

    private static BigInteger computeCoolTreshold(String input) {
        BigInteger total = BigInteger.valueOf(1);
        for (int i = 0; i < input.length(); i++) {
            if (isDigit(input.charAt(i))) {
                total = total.multiply(BigInteger.valueOf(input.charAt(i) - 48));
            }
        }
        return total;
    }
}
