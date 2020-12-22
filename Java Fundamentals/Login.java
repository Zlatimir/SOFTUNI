import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 24.5.2020 г..
 */
public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();
        String pass = "";
        for (int i = user.length() - 1; i >= 0; i--) {
            pass = pass + user.charAt(i);
        }
        int fails = 0;
        while (true) {
            String input = sc.nextLine();
            if (input.equals(pass)) {
                System.out.printf("User %s logged in.", user);
                break;
            } else {
                System.out.println("Incorrect password. Try again.");
                fails ++;
                if (fails>2){
                    System.out.printf("User %s blocked!",user);
                    break;
                }
            }
        }
    }
}
