import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 19.9.2020 г..
 */
public class StrongNumber {

    public static int factorial(int n){
        int result = 1;
        for (int i = 1; i <=n ;i++){
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int number = n;
        int sum = 0;
        while (n>0){
            int lastDigit = n%10;
            sum = sum + factorial(lastDigit);
            n = n / 10;
        }
        if (number == sum){
            System.out.println("yes");
        } else System.out.println("no");
    }
}
