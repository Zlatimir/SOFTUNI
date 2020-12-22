import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 20.9.2020 г..
 */

public class PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = Integer.parseInt(sc.nextLine());
        int end = Integer.parseInt(sc.nextLine());
        for (int i = start; i <= end ; i++) {
            System.out.printf("%s ", (char)i);
        }
    }
}
