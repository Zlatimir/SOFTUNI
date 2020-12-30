import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Zlatimir Ivanov on 30.12.2020 г..
 */

public class SortLines {
    public static void main(String[] args) {

        Path inPath = Paths.get("input.txt");

        Path outPath = Paths.get("output.txt");


        try {
            List<String> lines = Files.readAllLines(inPath);
            lines = lines.stream().filter(l -> !l.isEmpty()).collect(Collectors.toList());
            Collections.sort(lines);
            Files.write(outPath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
