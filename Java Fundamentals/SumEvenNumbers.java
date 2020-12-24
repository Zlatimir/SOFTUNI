import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 19.7.2020 г..
 */

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = Arrays.stream(sc.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();

        int sum = 0;
        for (int x: num) {
            if (x%2==0){
                sum = sum + x;
            }
        }
        System.out.println(sum);
    }
}
