import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 19.9.2020 г..
 */
public class PrintAndSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = Integer.parseInt(sc.nextLine());
        int end = Integer.parseInt(sc.nextLine());
        int sum = 0;
        for (int i = start; i<=end; i++){
            sum += i;
            System.out.printf("%d ",i);
        }
        System.out.println();
        System.out.printf("Sum: %d",sum);
    }
}
