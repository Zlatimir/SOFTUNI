import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Zlatimir Ivanov on 31.12.2020 г..
 */

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String input1 = "E:\\JAVA\\SOFTUNI\\SOFTUNI\\JavaAdvanced\\04.Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String input2 = "E:\\JAVA\\SOFTUNI\\SOFTUNI\\JavaAdvanced\\04.Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources-Exercises\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        List<String> lines1 = Files.readAllLines(Paths.get(input1));
        lines1 = lines1.stream().filter(l -> !l.isEmpty()).collect(Collectors.toList());
        List<String> lines2 = Files.readAllLines(Paths.get(input2));
        lines2 = lines2.stream().filter(l -> !l.isEmpty()).collect(Collectors.toList());
        lines1.addAll(lines2);

        for (String s : lines1) {
            System.out.println(s);
        }

    }
}
