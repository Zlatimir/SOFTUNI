import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 24.5.2020 г..
 */
public class SumofOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int sum = 0;
        for (int i = 1; i<=2*n; i+=2){
            System.out.println(i);
            sum = sum + i;
        }
        System.out.printf("Sum: %d",sum);
    }
}
