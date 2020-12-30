import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Zlatimir Ivanov on 30.12.2020 г..
 */

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int oneByte = inputStream.read();
        while (oneByte >= 0){
            System.out.print(Integer.toBinaryString(oneByte) + " ");
            oneByte = inputStream.read();
        }
    }
}
