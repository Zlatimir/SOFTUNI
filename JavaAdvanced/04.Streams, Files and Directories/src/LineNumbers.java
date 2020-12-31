import java.io.*;

/**
 * Created by Zlatimir Ivanov on 31.12.2020 г..
 */

public class LineNumbers {
    public static void main(String[] args) {
        String path = "E:\\JAVA\\SOFTUNI\\SOFTUNI\\JavaAdvanced\\04.Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            PrintWriter writer = new PrintWriter("output.txt");

            int n = 1;
            while (in.ready()){
                String line = in.readLine();
                writer.println(n + ". " + line);
                n++;
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
