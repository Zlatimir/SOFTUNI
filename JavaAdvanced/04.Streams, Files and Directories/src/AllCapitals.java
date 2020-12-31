import java.io.*;

/**
 * Created by Zlatimir Ivanov on 31.12.2020 г..
 */

public class AllCapitals {
    public static void main(String[] args) {

        String path = "E:\\JAVA\\SOFTUNI\\SOFTUNI\\JavaAdvanced\\04.Streams, Files and Directories\\src\\input.txt";
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            PrintWriter writer = new PrintWriter("output.txt");
            while (in.ready()){
                String line = in.readLine();
                    writer.println(line.toUpperCase());

            }
            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
