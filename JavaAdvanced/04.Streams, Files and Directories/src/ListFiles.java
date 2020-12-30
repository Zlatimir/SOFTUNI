import java.io.File;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * Created by Zlatimir Ivanov on 30.12.2020 г..
 */

public class ListFiles {
    public static void main(String[] args) {

        Path inPath = Paths.get("E:\\JAVA\\SOFTUNI\\SOFTUNI\\JavaAdvanced\\04.Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");


            File file = new File(String.valueOf(inPath));
            File[] files = file.listFiles();
        for (File file1 : files) {
            if(!file1.isDirectory()){
                System.out.printf("%s: [%d]%n", file1.getName(), file1.length());
            }
        }

    }
}
