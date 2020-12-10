package JavaFundExam04042020Practice;

import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 25.11.2020 г..
 */

public class PasswordReset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        String input = sc.nextLine();
        while (!input.equals("Done")){
            String[] command = input.split(" ");
            switch (command[0]){
                case "TakeOdd":
                    String newPass = "";
                    for (int i = 1; i < password.length(); i+=2) {
                        newPass = newPass + password.charAt(i);
                    }
                    password = newPass;
                    System.out.println(password);
                    break;
                case "Cut":
                    int index = Integer.parseInt(command[1]);
                    int length = Integer.parseInt(command[2]);
                    String left = password.substring(0, index);
                    String right = password.substring(index + length);
                    password = left + right;
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = command[1];
                    String substitute = command[2];
                    if (password.contains(substring)){
                        password = password.replace(substring, substitute);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            input = sc.nextLine();
        }
        System.out.println("Your password is: " + password);
    }
}
