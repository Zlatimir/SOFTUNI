import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Zlatimir Ivanov on 26.12.2020 г..
 */

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<String> names = new LinkedHashSet<>();

        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            names.add(input);
        }

        names.forEach(e -> System.out.println(e));
    }
}
