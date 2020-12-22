import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 20.7.2020 г..
 */

public class EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = Arrays.stream(sc.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();

        int sumEven = 0;
        int sumOdd = 0;
        for (int x: num) {
            if (x%2==0){
                sumEven = sumEven + x;
            } else {
                sumOdd = sumOdd +x;
            }
        }
        System.out.println(sumEven - sumOdd);
    }
}
