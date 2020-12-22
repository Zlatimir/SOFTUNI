import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 19.7.2020 г..
 */

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        for (int i = n-1; i >=0 ; i--) {
            System.out.printf("%d ", arr[i]);
        }
    }
}
