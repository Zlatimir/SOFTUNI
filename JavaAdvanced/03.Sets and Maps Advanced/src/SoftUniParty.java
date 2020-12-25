import java.util.*;

import static java.lang.Character.isDigit;

/**
 * Created by Zlatimir Ivanov on 25.12.2020 г..
 */

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String line = scan.nextLine();
        while (!line.equals("PARTY")) {
            if (isDigit(line.charAt(0))) {
                vip.add(line);
            } else {
                regular.add(line);
            }
            line = scan.nextLine();

        }
        line = scan.nextLine();

        while (!line.equals("END")){
            if (isDigit(line.charAt(0))) {
                vip.remove(line);
            } else {
                regular.remove(line);
            }
            line = scan.nextLine();
        }

        System.out.println(vip.size() + regular.size());

        for (String s : vip) {
            System.out.println(s);
        }

        for (String s : regular) {
            System.out.println(s);
        }
    }
}
