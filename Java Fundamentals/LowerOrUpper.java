import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 25.6.2020 г..
 */

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char ch = s.charAt(0);
        if (ch>64  &&ch<91  ){
            System.out.println("upper-case");
        } else if (ch>96  &&ch<123  ){
            System.out.println("lower-case");
        }
    }
}
