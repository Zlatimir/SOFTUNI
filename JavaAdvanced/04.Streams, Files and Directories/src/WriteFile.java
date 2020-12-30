import java.io.*;
import java.util.Scanner;

/**
 * Created by Zlatimir Ivanov on 30.12.2020 г..
 */

public class WriteFile {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("output.txt");


        int oneByte = inputStream.read();
        while (oneByte >=0){
            if (oneByte != ',' && oneByte != '.' && oneByte != '!' && oneByte != '?'){
                outputStream.write(oneByte);
            }
            oneByte = inputStream.read();
        }
    }
}
