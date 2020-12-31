import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Zlatimir Ivanov on 31.12.2020 г..
 */

public class SumBytes {
    public static void main(String[] args) {

        String path = "E:\\JAVA\\SOFTUNI\\SOFTUNI\\JavaAdvanced\\04.Streams, Files and Directories\\src\\input.txt";
        int sum = 0;

        try {
            BufferedReader in = new BufferedReader(new FileReader(path));


            while (in.ready()){
                String line = in.readLine();
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sum);

    }
}
