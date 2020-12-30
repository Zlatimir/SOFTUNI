import java.io.*;

/**
 * Created by Zlatimir Ivanov on 30.12.2020 г..
 */

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));

        int count = 0;
        while (in.ready()){
            count++;
            String line = in.readLine();
            if (count % 3 == 0){
                out.println(line);
            }
        }
        out.flush();
        out.close();

    }
}
