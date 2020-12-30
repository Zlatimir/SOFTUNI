import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 30.12.2020 г..
 */

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("input.txt");
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        Scanner scan = new Scanner(inputStream);

        while (scan.hasNext()){
            if (scan.hasNextInt()){
                String str = String.valueOf(scan.nextInt());
                for (int i = 0; i < str.length(); i++) {
                    outputStream.write(str.charAt(i));
                }
                outputStream.write('\n');
            }
            scan.next();
        }
    }
}
