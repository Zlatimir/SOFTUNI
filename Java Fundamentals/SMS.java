import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 17.5.2020 г..
 */
public class SMS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String sms = "";
        for (int i = 1; i<=n; i++){
            int num = Integer.parseInt(sc.nextLine());
            String nn = "" + num;
            if (num == 0) {
                sms = sms + " ";
            } else {
                int mainDigit = num % 10;
                int nOfDigits = nn.length();
                int offset = (mainDigit - 2) * 3;
                if (mainDigit == 8 || mainDigit == 9){
                    offset = offset + 1;
                }
                int index = offset + nOfDigits -1;
                sms = sms + Character.toString((char)(97 + index));
            }
        }
        System.out.println(sms);
    }
}
