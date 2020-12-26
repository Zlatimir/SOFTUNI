import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;


/**
 * Created by Zlatimir Ivanov on 26.12.2020 г..
 */

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> elements = new TreeSet<>();
        
        int n = Integer.parseInt(scan.nextLine());

        for (int i = 0; i < n; i++) {
            String[]data = scan.nextLine().split("\\s+");
            for (int j = 0; j < data.length; j++) {
                elements.add(data[j]);
            }

        }

        for (String s : elements) {
            System.out.print(s + " ");
        }

    }
}
