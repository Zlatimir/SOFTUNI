import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 19.9.2020 г..
 */
public class Division {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int answer = 0;
        if (n%2==0) answer = 2;
        if (n%3==0) answer = 3;
        if (n%6==0) answer = 6;
        if (n%7==0) answer = 7;
        if (n%10==0) answer = 10;
        if (answer==0){
            System.out.println("Not divisible");
        } else System.out.printf("The number is divisible by %d",answer);
    }
}
