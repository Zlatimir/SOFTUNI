import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException, InterruptedException {
        Homework homework = new Homework();
        //ToDo - change Username and Password here
        homework.setConnection("root", "root");
        System.out.println("Enter exercise number [2 - 9] (0 - for exit):");
        int exNum = Integer.parseInt(scanner.nextLine());
        switch (exNum) {
            case 2:
                homework.exercise2();
                break;
            case 3:
                homework.exercise3();
                break;
            case 4:
                homework.exercise4();
                break;
            case 5:
                homework.exercise5();
                break;
            case 6:
                homework.exercise6();
                break;
            case 7:
                homework.exercise7();
                break;
            case 8:
                homework.exercise8();
                break;
            case 9:
                System.out.println("Do you already create procedure 'usp_get_older'?");
                System.out.println("Because I want to use it ;)");
                Thread.sleep(2000);
                homework.exercise9();
                break;
                case 0:

                break;
            default:
                System.out.println("Wrong number!");
        }

    }
}
