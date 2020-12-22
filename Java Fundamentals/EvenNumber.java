import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 24.5.2020 г..
 */
public class EvenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            int n = Integer.parseInt(sc.nextLine());
            if (n%2==0){
                System.out.printf("The number is: %d",Math.abs(n));
                break;
            } else {
                System.out.println("Please write an even number.");
            }
        }
    }
}
