import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Zlatimir Ivanov on 30.12.2020 г..
 */

public class NestedFolders {
    public static void main(String[] args) {

        String inPath = "E:\\JAVA\\SOFTUNI\\SOFTUNI\\JavaAdvanced\\04.Streams, Files and Directories\\04. Java-Advanced-Streams-Files-and-Directories-Resources" +
                "\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(inPath);

        Deque<File> listFiles = new ArrayDeque<>();

        listFiles.offer(file);

        int count = 1;

        while (!listFiles.isEmpty()){
            File f = listFiles.poll();
            count++;
            System.out.println(f.getName());

            File[] files = f.listFiles();
            for (File inner : files) {
                if (inner.isDirectory()){
                    listFiles.offer(inner);
                }

            }
        }
        System.out.println(count + "folders");
    }
}
