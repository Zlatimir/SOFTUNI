import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 20.9.2020 г..
 */
public class SumDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        num = Math.abs(num);
        int sum = 0;
        while (num > 0){
            sum = sum + (num % 10);
            num = num / 10;
        }
        System.out.println(sum);
    }
}
