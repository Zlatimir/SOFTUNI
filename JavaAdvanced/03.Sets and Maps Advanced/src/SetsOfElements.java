import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Zlatimir Ivanov on 26.12.2020 г..
 */

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();
        Set<Integer> third = new LinkedHashSet<>();

        String[] line = scan.nextLine().split("\\s+");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scan.nextLine());
            first.add(number);
        }

        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(scan.nextLine());
            second.add(number);
        }

        if (m <= n){
            for (Integer i : first) {
                if (second.contains(i)){
                    third.add(i);
                }
            }
        } else {
            for (Integer i : second) {
                if (first.contains(i)){
                    third.add(i);
                }
            }
        }

        if (n == 0){
            third = second;
        }
        if (m == 0){
            third = first;
        }


        for (Integer i : third) {
            System.out.print(i + " ");
        }
    }
}
