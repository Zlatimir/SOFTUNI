import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Zlatimir Ivanov on 30.12.2020 г..
 */

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("input.txt");
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        int oneByte = inputStream.read();

        while (oneByte >= 0){
            if (oneByte != 32 && oneByte != '\n') {
                String digits = String.valueOf(oneByte);
                for (int i = 0; i < digits.length(); i++) {
                    outputStream.write(digits.charAt(i));
                }
            } else {
                outputStream.write(oneByte);
            }
            oneByte = inputStream.read();
        }
    }
}
